package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 자동 의존 관계 주입 애노테이션을 생성자에 붙이면 -> MemberRepository 타입에 맞는 구현체를 가져와서 자동으로 의존 관계 주입
    @Autowired   // applicationContext.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {   // 생성자 주입
        this.memberRepository = memberRepository;   // MemoryMemberRepository 에 대한 코드 X (인터페이스에만 의존)
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);   // 다형성에 의해 MemoryMemberRepository 의 save() 메서드 선택 및 실행
   }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}