package com.study.web.admin.repository;

import com.study.web.admin.domain.Member;
import com.study.web.admin.repository.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class MybatisMemberRepository implements IMemberRepository{

    @Autowired
    MemberMapper _memberMapper;

    public MybatisMemberRepository(){
    }

    @Override
    public Member save(Member member) {

        return _memberMapper.save(member);
    }

    @Override
    public Member findbyId(Long id) {

        return _memberMapper.findbyId(id);
    }

    @Override
    public Member findbyName(String name) {
        return _memberMapper.findbyName(name);
    }

    @Override
    public List<Member> findAll() {

        //log.debug("test");
        System.out.println("test111");
        List<Member> members = _memberMapper.findbyAll();
        System.out.println("test222");
        System.out.println(members.get(0).getName());

        return _memberMapper.findbyAll();
    }
}
