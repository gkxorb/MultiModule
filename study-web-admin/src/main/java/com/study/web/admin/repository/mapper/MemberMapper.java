package com.study.web.admin.repository.mapper;

import com.study.web.admin.domain.Member;

import java.util.List;

public interface MemberMapper {

    Member save(Member member);

    Member findbyId(Long id);

    Member findbyName(String name);

    List<Member> findbyAll();
}
