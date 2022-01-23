package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// 해당 클래스에서 command + shift + T = Create New Test
//@Service
// JPA 를 사용하려면 항상 트랜잭션이 있어야 함.
@Transactional
public class MemberService {
    // MemberService 입장에서 직접 new를 하지 않음(MemberRepository를 외부에서 넣어줌) -> Dependency Rejection

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    /**
     * 회원가입
     */
//    @Transactional
    // 클래스 말고 회원가입에 있어도 됨(회원가입만 하므로)
    public Long join(Member member) {
        // 같은 이름인 중복 회원 X
        // Optional 안에 member 객체 존재

//        Optional<Member> result = memberRepository.findByName(member.getName());   // command + option + v = Optional
////       result.orElseGet();// 값이 있으면 꺼내기
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member);   // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     *  전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
