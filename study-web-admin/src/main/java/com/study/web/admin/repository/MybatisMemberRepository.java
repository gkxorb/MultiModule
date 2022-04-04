package com.study.web.admin.repository;

import com.study.web.admin.domain.Member;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
public class MybatisMemberRepository implements IMemberRepository{


    public MybatisMemberRepository(DataSource dataSource){

    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member findbyId(Long id) {
        return null;
    }

    @Override
    public Member findbyName(String name) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
