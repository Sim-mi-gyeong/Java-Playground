package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);   // @Autowired 가 없어도, AutoAppConfigTest 를 실행할 경우 값이 들어온 것을 확인할 수 있음
        this.memberRepository = memberRepository;   // MemoryMemberRepository 할당
        this.discountPolicy = discountPolicy;   // FixDiscountPolicy 할당
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);   // OrderService 입장에서는 모르고, 결과만 던지도록 (단일 책임 원칙 준수)

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
