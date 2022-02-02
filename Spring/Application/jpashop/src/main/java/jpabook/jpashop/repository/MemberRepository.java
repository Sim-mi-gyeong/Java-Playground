package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository   // 스프링 부트가 빈으로 등록
@RequiredArgsConstructor
public class MemberRepository {

    /**
     [방법 1] @PersistenceContext
     */
//    @PersistenceContext   // 스프링이 엔티티 매니저를 만들어 (엔티티에) 주입(Injection) 해줌

    /**
     [방법 2] @PersistenceContext 대신 @Autowired - 스프링 부트가 지원해주는 라이브러리(스프링 Data JPA)를 사용하기 때문
     */
//    @Autowired
//    private EntityManager em;
//
//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    }
    /**
     [방법 3] @Autowired 가 가능 -> @RequiredArgsConstructor 를 통해 생성자 생략 가능
     */
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);   // member 를 찾아 반환 (첫번째: 타입, 두번째: PK)
    }

    public List<Member> findAll() {
        // JPQL 작성
//        List<Member> result = em.createQuery("select m from Member m", Member.class)   // 첫번째: JPQL 작성, 두번째: 반환 타입
//                .getResultList();   // Members 를 리스트로 만들어줌
//        return result;

        // Inline 표시
        return em.createQuery("select m from Member m", Member.class)   // 첫번째: JPQL(엔티티 객체를 대상으로 쿼리) 작성, 두번째: 반환 타입
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)   // 파라미터가 바인딩
                .getResultList();
    }

}
