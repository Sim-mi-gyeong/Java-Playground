package hello.core.scan;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   // TYPE : 클래스 레벨
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {   // 컴포넌트 스캔 대상에 추가
}
