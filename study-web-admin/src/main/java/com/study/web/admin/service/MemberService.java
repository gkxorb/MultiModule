package com.study.web.admin.service;

import com.study.web.admin.domain.Member;
import com.study.web.admin.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Ctrl + Shipt + t : 테스트 코드 생성.
//@Service -- 저장소 구현체를 변겨하기 위해 빈을 이용해 등록.
@Transactional
public class MemberService {

    private final IMemberRepository _memberRepository;

    //@Autowired -- 저장소 구현체를 변겨하기 위해 빈을 이용해 등록.     *
    public  MemberService (IMemberRepository memberRepository){
        this._memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long Join(Member member) {

        /*
        //ctrl+alt+m 으로 함수로 분리.
        Optional<Member> result = _memberRepository.findbyName(member.getName());
        result.ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */

        validateDuplicateMember(member); // 중복 회원 조회

        _memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Ctrl + Alt+ v : 변수 추출.
        Member result = _memberRepository.findbyName(member.getName());

        if(result.getName() != null && result.getName().equals(member.getName())) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMemebers(){
        return _memberRepository.findAll();
    }

    /**
     * 회원 조회
     */
    public Member findOne(Long memberId){
        return _memberRepository.findbyId(memberId);
    }
}
