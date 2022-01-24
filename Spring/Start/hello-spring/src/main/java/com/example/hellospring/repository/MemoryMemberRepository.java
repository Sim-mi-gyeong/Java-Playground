package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{   // implements 할 때 option + enter
    private static Map<Long, Member> store = new HashMap<>();   // 동시성 문제 고려
    private static long sequence = 0L;   // key 값 생성해줌

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   // store에 save 하기 전 member의 id 값 세팅
        store.put(member.getId(), member);   // store에 시스템에 저장된 이름 가져오기
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));   // 만약 값이 없다면? -> null값 방지를 위해 Optional
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()   // 루프를 돌리며 -> member.getName()이 파라미터로 전달된 name과 같은지 확인 -> 같은 경우에만 필터링, 찾으면 반환
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());   // store.values() 는 member
    }

    public void clearStore() {
        store.clear();
    }
}
