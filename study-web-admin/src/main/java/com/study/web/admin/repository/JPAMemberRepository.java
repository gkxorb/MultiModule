package com.study.web.admin.repository;

import com.study.web.admin.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JPAMemberRepository implements IMemberRepository {

    private  final EntityManager _entityManager;

    public  JPAMemberRepository(EntityManager entityManager){
        this._entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        _entityManager.persist(member);
        return null;
    }

    @Override
    public Member findbyId(Long id) {
        return Optional.ofNullable( _entityManager.find(Member.class, id)).orElseGet(Member::new);
    }

    @Override
    public Member findbyName(String name) {
        return _entityManager.createQuery("SELECT m FROM Member m WHERE m.name =  :name", Member.class).setParameter("name", name)
                .getResultList()
                .stream()
                .findAny()
                .orElseGet(Member::new);
    }

    @Override
    public List<Member> findAll() {
        return _entityManager.createQuery("SELECT m from Member m", Member.class).getResultList();
    }
}
