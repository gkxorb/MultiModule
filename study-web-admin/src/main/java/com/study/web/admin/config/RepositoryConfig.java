package com.study.web.admin.config;

import com.study.web.admin.repository.IMemberRepository;
import com.study.web.admin.repository.MybatisMemberRepository;
import com.study.web.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    /** 의존 관계 주입
     * 생성자 주입, 필드 주입 (컴포넌트 스캔) - 정형화 된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔 사용. @Service.@Repository, @Autowired...
     * 자바 코드를 이용한 스프링 빈 등록. - 정형화 되지 않거나 상황에 따라 인터페이스의 구현체를 변경해야 하는 경우 스프링 빈을 이용하여 등록.
     */
    private final DataSource _h2Datasource;
    private final DataSource _sqlDatasource;
    //private final EntityManager _entityManager;

    /**
     *
     * @param H2DataSource    DataSourceConfig.java Bean 연결.
     * @param SqlDataSource   DataSourceConfig.java Bean 연결.
     * #@param entityManager
     */
    @Autowired
    public RepositoryConfig(@Qualifier("H2DataSource")DataSource H2DataSource, @Qualifier("MsSQLDataSource")DataSource SqlDataSource/*, @Qualifier("h2EntityManager") EntityManager entityManager*/ ) {

        this._h2Datasource = H2DataSource;
        this._sqlDatasource = SqlDataSource;
        //this._entityManager = entityManager;
    }

    // MemberService - 코드를 이용하여 등록 시 @Service, @Autowired 제거.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // MemberRepository - 코드를 이용하여 등록 시 인터페이스 구현체( MemoryMemberRepository )의 @Repository 제거.
    @Bean
    public IMemberRepository memberRepository(){
        //return new MemoryMemberRepository();                              // Memory 객체 저장
        //return new JdbcMemberRepository(this._datasource);                // Jdbc를 이용한 저장
        //return new JdbcTemplateMemberRepository(this._h2Datasource);        // Jdbc Template 를 이용한 저장
        return new MybatisMemberRepository();                               // Mybatis 를 이용한 저장
        //return new JPAMemberRepository(this._entityManager);              // JPA를 이용한 저장
    }

}
