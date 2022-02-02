package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional   // 스프링에서는 기본적으로, Transactional 이 롤백을 함
public class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {   // 같은 트랜잭션 안에서, PK 가 같으면, 같은 영속성 컨텍스트 내에서 같은 것으로 걸림
        // given
        Member member = new Member();
        member.setName("Kim");

        // when
        Long saveId = memberService.join(member);

        // then(예상 결과)
//        em.flush();   // Rollback(false) 를 지운 상태에서 flush() 를 하면 Insert 쿼리문 확인 가능
        assertEquals(member, memberRepository.findOne(saveId));
    }


    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        // when
        memberService.join(member1);
        /**
         * @Test(expected = IllegalStateException.class) 가 없을 때
         */
//        try {
//            memberService.join(member2);   // 예외가 발생해야 한다!
//        } catch (IllegalStateException e) {
//            return;
//        }
        /**
         * @Test(expected = IllegalStateException.class) 사용 시 코드 간결
         */
        memberService.join(member2);

        // then
        fail("예외가 발생해야 한다!!!!");

    }

}
