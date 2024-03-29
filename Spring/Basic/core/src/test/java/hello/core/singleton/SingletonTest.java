package hello.core.singleton;

import hello.core.config.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();   // memberService 생성자 파라미터인 memberRepository() 까지 실행되어 -> 4개의 객체가 새로 생성됨

        // 2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인 -> JVM 메모리에 계속해서 새로운 객체가 생성되어 올라감
        System.out.println("memberService1 = " + memberService1);   // @23348b5d
        System.out.println("memberService2 = " + memberService2);   // @23348b5d

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);   // @7bedc48a
        System.out.println("singletonService2 = " + singletonService2);   // @7bedc48a

        assertThat(singletonService1).isSameAs(singletonService2);
        // isSameAs : == (객체 인스턴스 비교)
        // isEqualTo : equals ()
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = applicationContext.getBean("memberService", MemberService.class);
        MemberService memberService2 = applicationContext.getBean("memberService", MemberService.class);

        // 참조값이 같은 것을 확인
        System.out.println("memberService1 = " + memberService1);   // @5cbe877d
        System.out.println("memberService2 = " + memberService2);   // @5cbe877d

        assertThat(memberService1).isSameAs(memberService2);
    }
}
