package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;   // 스프링부트가 EntityManager 자동 생성 -> 생성자로 Injection 하면 됨.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
//        List<Member> result = em.createQuery("select m  from Member m", Member.class).getResultList();
//        return result;
        // inline 으로 표기
        // Member Entity 를 대상으로 쿼리를 날림 (객체 자체를 select)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
