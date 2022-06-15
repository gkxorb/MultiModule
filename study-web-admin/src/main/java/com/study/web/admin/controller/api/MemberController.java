package com.study.web.admin.controller.api;

import com.study.web.admin.domain.Member;
import com.study.web.admin.domain.template.MemberForm;
import com.study.web.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private  final MemberService _memberService;

    @Autowired
    public MemberController(MemberService memberService){

        this._memberService = memberService;
    }

    @GetMapping("/")
    public  String Home(){

        return "home";
    }

    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/memberForm";
    }


    @GetMapping(value = "/members")
    public String getMemberList(Model model){

        List<Member> members = _memberService.findMemebers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm memberForm){

        Member member = new Member();
        member.setName( memberForm.getName());

        _memberService.Join(member);

        System.out.println("test : " + member.getName());

        return "redirect:/";
    }
}
