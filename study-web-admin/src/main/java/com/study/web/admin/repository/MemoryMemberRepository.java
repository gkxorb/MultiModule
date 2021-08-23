package com.study.web.admin.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.study.web.admin.domain.Member;
import org.springframework.stereotype.Repository;

//@Repository // -- 저장소 구현체를 변겨하기 위해 빈을 이용해 등록. <-- IMemberRepository 인터페이스의 구현체애 중복 빈 등록 시 에러 발생 함. (의존성 관계 중복!)
public class MemoryMemberRepository implements IMemberRepository {

    private final Map<Long, Member> _store = new HashMap<>();
    private long _seq = 0;

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(_store.values());
    }

    @Override
    public Member findbyId(Long id) {

        return Optional.ofNullable( _store.get(id) ).orElseGet(Member::new);
    }

    @Override
    public Member findbyName(String name) {

        return _store.values().stream()
                            .filter(member -> member.getName().equals(name)).findAny().orElseGet(Member::new);
    }

    @Override
    public Member save(Member member) {

        member.setId(++_seq);
        _store.put(member.getId(), member);

        return member;
    }

    public void clearStore() {
        _store.clear();
    }

}
