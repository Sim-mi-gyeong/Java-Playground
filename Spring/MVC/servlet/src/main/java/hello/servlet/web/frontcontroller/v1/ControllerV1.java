package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    // Servlet 가 모양이 똑같은 메서드 -> 다형성을 이용해 인터페이스를 구현 예정
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
