package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);   // 회원이 저장소에 저장
    Optional<Member> findById(Long id);   // null 값이 존재할 수 있어 Optional로 감싸서 반환 -> java8에 있는 기능
    Optional<Member> findByName(String name);
    List<Member> findAll();   // 지금까지 저장된 회원 리스트 반환
}
