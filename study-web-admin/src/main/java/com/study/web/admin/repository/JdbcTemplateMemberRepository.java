package com.study.web.admin.repository;

import com.study.web.admin.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JdbcTemplateMemberRepository implements IMemberRepository{

    private  final JdbcTemplate _jdbcTemplate;

    //@Autowired <-- 생성자가 1개이면 제외해도 됨.
    public JdbcTemplateMemberRepository(DataSource dataSource){
        this._jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this._jdbcTemplate);
        jdbcInsert.withTableName("MEMBER").usingGeneratedKeyColumns("ID");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", member.getName());

        log.debug("test - " + parameters.get("NAME"));

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Member findbyId(Long id) {

        List<Member> result = _jdbcTemplate.query("SELECT * FROM MEMBER WHERE ID = ?", memberRowMapper(), id);
        return result.stream().findAny().orElseGet(Member::new);
    }

    @Override
    public Member findbyName(String name) {
        List<Member> result = _jdbcTemplate.query( "SELECT * FROM MEMBER WHERE NAME = ?", memberRowMapper(), name);
        return result.stream().findAny().orElseGet(Member::new);
    }

    @Override
    public List<Member> findAll() {
        return _jdbcTemplate.query("SELECT * FROM MEMBER", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("ID"));
            member.setName(rs.getString("NAME"));
            return member;
        };

        /* Alt+Enter --> Replace Lamda
        return new RowMapper<Member>() {
             @Override
             public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Member member = new Member();
                 member.setId(rs.getLong("ID"));
                 member.setName(rs.getString("NAME"));
                 return member;
             }
        }*/
    }
}
