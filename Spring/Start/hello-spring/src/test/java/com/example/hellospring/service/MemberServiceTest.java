package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemoryMemberRepository memberRepository;

    // MemberService에 있는 memberRepository는 MemberServiceTest에서의 memberRepository 와 다른 객체
    // -> 다른 인스턴스 이므로 내용물이 달라질 수 있음.
    // private  static Map<Long, Member> store = new HashMap<>(); 에서 Member가 static이 아니면

    // Test 실행할 때마다 MemoryMemberRepository를 만들고
    // memberService에서 넣어줌. -> 같은 MemoryMemberRepository가 사용됨!
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
//        member.setName("hello");
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        // 우리가 찾는 게, repository에 있는지 확인 필요
//        Optional<Member> findMember = memberService.findOne(saveId);   // 메서드 쪽에서 command + Option + v
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*
      try {
            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
            fail();
        } catch (IllegalStateException e)  {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123");
//            expected: "이미 존재하는 회원입니다. 123"
//            but was: "이미 존재하는 회원입니다."
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/


        // then
    }
//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void findOne() {
//    }
}