package hello.core.config;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {   // MemberService 의 구현은 -> MemberServiceImpl 사용
        return new MemberServiceImpl(memberRepository());   // memberServiceImpl 애플리케이션에서 MemberRepository 에 대한 것은 -> MemoryMemberRepository 사용
    }

    @Bean
    public MemberRepository memberRepository() {   // 메드명을 통해 역할이 명시됨
        return new MemoryMemberRepository();   // 이후 변경 사항 발생 시 해당 코드에서 구현 클래스만 변경
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}