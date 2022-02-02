package jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

// 엔티티 메니저를 통한 모든 데이터 명령은 트랜잭션 내에서 이루어져야 함
@WebAppConfiguration
@RunWith(SpringRunner.class)   // JUnit 에게 알려주어야 함
@SpringBootTest
class MemberSubRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        // given
        MemberSub memberSub = new MemberSub();
        memberSub.setUsername("memberA");
        // when
        Long saveId = memberRepository.save(memberSub);
        MemberSub findMemberSub = memberRepository.find(saveId);
        // then
        Assertions.assertThat(findMemberSub.getId()).isEqualTo(memberSub.getId());
        Assertions.assertThat(findMemberSub.getUsername()).isEqualTo(memberSub.getUsername());
        Assertions.assertThat(findMemberSub).isEqualTo(memberSub);
        // 같은 영속성 Context 안에서는, Id 값이 같이면 같은 엔티티로 식별(인식)
//        System.out.println("findMember == member : " + (findMember == member));


    }

}