package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
// 테스트 후 DB 데이터를 지워 반복 가능
// @Transactional 어노테이션을 test 에 달면 test 실행할 때 먼저 트랜잭션을 하고 -> DB의 데이터를 insert ~ 하고 끝난 후 DB의 데이터를 롤백해줌
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    @Autowired MemberRepository memberRepository;

    // MemberService에 있는 memberRepository는 MemberServiceTest에서의 memberRepository 와 다른 객체
    // -> 다른 인스턴스 이므로 내용물이 달라질 수 있음.
    // private  static Map<Long, Member> store = new HashMap<>(); 에서 Member가 static이 아니면

    // Test 실행할 때마다 MemoryMemberRepository를 만들고
    // memberService에서 넣어줌. -> 같은 MemoryMemberRepository가 사용됨!


    // Spring Container 에게 MemberService / MemberRepository 를 달라고 해야함.
    // Constructor 로 Injection 말고, Test 는 필드 기반의 @Autowired 로 Injection

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
//        member.setName("hello");
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        // 우리가 찾는 것이, repository 에 있는지 확인 필요
//        Optional<Member> findMember = memberService.findOne(saveId);   // 메서드 쪽에서 command + Option + v
//        Member findMember = memberService.findOne(saveId).get();
//        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
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
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다
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

}