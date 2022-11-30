package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * 로그 출력을 위한 MyLogger 클래스
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    // requestURL 을 이후 별도 세팅하기 위해 setter 생성
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] "+ "message = " + message);
    }

    @PostConstruct
    public void init() {   // 고객 요청이 들어와 -> 최초로 스프링에 빈 호출할 때
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);   // 주소까지 출력
    }

    @PreDestroy
    public void close() {   // 고객 요청이 빠져나갈 때 빈 소멸
        System.out.println("[" + uuid + "] request scope bean close : " + this);   // 주소까지 출력
    }

}
