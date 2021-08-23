package com.study.web.admin.repository;

import com.study.web.admin.domain.Member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository _repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        _repository.clearStore();
    }

    //org.junit.jupiter.api 패키지의 Test 사용.
    @Test
    public void save() {

        Member member = new Member();
        member.setName("spring");
        _repository.save(member);

        Member result = _repository.findbyId(member.getId());

        // member 가 result 가 동일할지 확인.
        // org.assertj.core.api.Assertions.* 를 Static Import 하여 함수 명시만으로 사용 가능.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        _repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        _repository.save(member2);

        //데이터 확인
        Member member = _repository.findbyName("spring1");
        assertThat(member).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        _repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        _repository.save(member2);

        //데이터 저장 수 확인
        List<Member> memberList = _repository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }

}
