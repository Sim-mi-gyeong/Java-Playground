package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

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