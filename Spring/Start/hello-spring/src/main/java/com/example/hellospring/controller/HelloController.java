package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";   // resources의 temlplates 아래에서 hello를 찾음
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // http에서 response header부에 data를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;   // "hello spring", "hello kim" -> 문자만 그대로 넘어감(페이지 소스 보기를 했을 때 html 태그 X)
    }

    @GetMapping("hello-api")
    @ResponseBody   // 해당 annotation이 붙어 있을 때는 data를 그대로 넘김(객체가 오면 json 방식으로 http 응답에 반응)
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }// Hello 라는 객체 생성

    static class Hello {   // static class : class안에 또 생성 가눙
        private String name;   // java been 방식

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
