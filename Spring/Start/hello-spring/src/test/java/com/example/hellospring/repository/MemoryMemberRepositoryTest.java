package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {   // class run 하면 그 안에 메서드 전체 테스트 케이스 확인 가능

//    MemberRepository repository = new MemoryMemberRepository();

    // MemoryMemberRepository만 테스트 하므로 인터페이스가 아닌 MemoryMemberRepository로 변경
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();   // test가 실행되고 끝날 때마다 메모리를 지움!! -> 테스트는 순서에 상관없이(즉, 서로 의존 관계 없이) 설계되어야 함.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();;   // Optional에서 값을 꺼낼 때에는 .get() 메서드 사용!
        // 저장한 member와 DB에서 꺼낸 것이 같으면 일치

//        System.out.println("result = " + (result == member));
        // member: 기대했던 것(new로 저장한 member가 find했을 때와 같은가?)
//        Assertions.assertEquals(member, null);  Expected :com.example.hellospring.domain.Member@5e955596
//                                                Actual   :null
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();   // shift + F6 = Rename
        member2.setName("spring2");
        repository.save(member2);

//        Optional<Member> result = repository.findByName("spring1");
        Member result = repository.findByName("spring1").get();   // .get()을 사용하면 Optional 빼고 사용 가능

        assertThat(result).isEqualTo(member1);
//        assertThat(result).isEqualTo(member2);   expected: com.example.hellospring.domain.Member@161b062a
//                                                 but was: com.example.hellospring.domain.Member@50a7bc6e  // 다른 객체임을 확인
    }

    @Test
    public void findAll() {
        // 순서에 의존되어 실행되는 경우
        // findAll() 메서드가 먼저 실행되는 경우 member1 과 member2가 이미 저장되어
        // fineByName() 메서드 실행 시 이전에 findAll()에서 저장된 객체가 먼저 나오는 것!
        // 따라서, Test가 하나 끝나는 경우 Data를 Clear 해주어야 함(repository 비워주기)
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
//        assertThat(result.size()).isEqualTo(3);   // expected: 3  but was: 2
        assertThat(result.size()).isEqualTo(2);

    }

}
