package com.study.web.admin.repository;

import java.util.List;
import java.util.Optional;

import com.study.web.admin.domain.Member;

public interface IMemberRepository {
    Member save(Member member);

    Member findbyId(Long id);

    Member findbyName(String name);

    List<Member> findAll();
}
