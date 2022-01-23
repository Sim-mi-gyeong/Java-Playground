package com.example.hellospring;

import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    // 뜰 때, MemberService 와 MemberRepository 를 스프링 빈에 등록하고
    // 스프링 빈에 등록되어 있는 MemberRepository 를 MemberService 에 넣어줌

/*
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
 */
//    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());   // 오류 -> 생성자 넣어주어야 함
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();   // MemberRepository 는 인터페이스 MemoryMemberRepository 는 구현체
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
        return 
    }

}
