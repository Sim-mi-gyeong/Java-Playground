package hello.core.beanfind;

import hello.core.config.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);   // SameBeanConfig 클래스에 있는 2개의 스프링 빈만 등록

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있는 경우, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
//        MemoryMemberRepository bean = applicationContext.getBean(MemoryMemberRepository.class);   // 타입만 지정한 경우, 스프링 입장에서 꺼내는 빈이 2개
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> applicationContext.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있는 경우, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = applicationContext.getBean("memberRepository1", MemoryMemberRepository.class);   // 타입만 지정한 경우, 스프링 입장에서 꺼내는 빈이 2개
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = applicationContext.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {   // static class -> class 안에 class : Scope 를 해당 클래스 안에서만 사용하겠다는 것

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
