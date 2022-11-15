package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();   // 구현 객체 선택

    @Override
    public void join(Member member) {
        memberRepository.save(member);   // 다형성에 의해 MemoryMemberRepository 의 save() 메서드 선택 및 실행
   }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}