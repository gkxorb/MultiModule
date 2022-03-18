package com.study.web.admin.service;

import com.study.web.admin.domain.Member;
import com.study.web.admin.repository.IMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional      // Test 후 RollBack 해줌. - 각 Test Function 마다 RollBack
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService _memberService;

    @Autowired
    IMemberRepository _memberRepository;

    @Test
    @Commit     // @Transactional 에 대한 옵션 - 해당 Function은 Commit 됨!
    void  회원가입() {
        //given - 무언가 주어졌을때
        Member givenMember = new Member();
        givenMember.setName("hello");

        //when - 이것을 실핼하면
        Long saveId = _memberService.Join(givenMember);
        List<Member> memberList = _memberService.findMemebers();

        //then - 결과가 이렇게 되어야 함.
        Member saveMember = _memberService.findOne(saveId);
        assertThat(givenMember.getName()).isEqualTo(saveMember.getName());
        assertThat(memberList.size()).isEqualTo(1);
    }

    @Test
    void JoinDuplicate() {
        //given - 무언가 주어졌을때
        Member givenMember1 = new Member();
        givenMember1.setName("hello");

        Member givenMember2 = new Member();
        givenMember2.setName("hello");

        //when - 이것을 실핼하면
        _memberService.Join(givenMember1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> _memberService.Join(givenMember2));

        //then - 결과가 이렇게 되어야 함.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMemebers() {

        //given
        //when
        List<Member> memberList = _memberService.findMemebers();

        //then
        assertThat(memberList.size()).isEqualTo(0);
    }

    @Test
    void findOne() {
    }
}
