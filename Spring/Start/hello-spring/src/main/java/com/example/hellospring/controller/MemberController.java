package com.example.hellospring.controller;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Controller annotation : 스프링이 뜰 때, 스프링 컨테이너에 컨트롤러가 있으면 -> MemberController 객체를 생성해 넣어주고, 스프링이 관리
@Controller
public class MemberController {
    // 방법 2) 필드 주입 -> 중간에 바꿀 수 없음! (비선호)
//    @Autowired private MemberService memberService;

    private final MemberService memberService;
    // Autowired : 스프링 컨테이너에서 멤버 컨테이너를 가져옴
    // 생성자에 @Autowired 가 있으면 memberService 를 스프링이 컨테이너에 있는 MemberService 를 가져와 연결해줌

    // 방법 1) 생성자 주입 : 생성자를 통해 MemberService 가 MemberController 에 주입됨. (생성할 시점에만 넣고, 그 다음 변경 불가하게)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 방법 3) Setter Injection : Setter: set~ 는 누군가가 호출했을 때 public 으로 열려 있어야 함
//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // GetMapping : 조회할 때 사용
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";   // members 의 createMemberForm 으로 이
    }

    // PostMapping : 데이터를 Form 에 넣어서 전달할 때
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";   // 회원가입이 끝나고 Home 화면으로 돌리기
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);   // key : members 리스트로 모든 members 를 넣어줌

        return "members/memberList";
    }


}