package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;   // 스프링 ui에 있는 모델로, 데이터를 실어서 View로 넘길 수 있음
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";   // hello.html
    }

    public static void main(String[] args) {

    }
}
