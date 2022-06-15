package com.study.web.admin.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.study.web.admin.repository.mapper")
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("H2DataSource") DataSource H2DataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(H2DataSource);

        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);  // Virtual File System (파일 등의 시스템 리소스에 접근할 수 있도록 설정.)
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-cfg.xml"));

        return sqlSessionFactoryBean.getObject();
    }
}
