package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component 애노테이션이 붙은 클래스를 찾아 -> 자동으로 스프링 빈으로 등록
// @Configuration 도 컴포넌트 스캔 대상이 됨
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)   // 컴포넌트 스캔을 통해 자동으로 스프링 빈 등록에서 제외할 것을 지정
)
public class AutoAppConfig {
/*
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
 */
}
