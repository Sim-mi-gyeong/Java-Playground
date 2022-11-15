package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;   // MemoryMemberRepository 할당
        this.discountPolicy = discountPolicy;   // FixDiscountPolicy 할당
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);   // OrderService 입장에서는 모르고, 결과만 던지도록 (단일 책임 원칙 준수)

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
