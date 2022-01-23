package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")   // localhost 로 들어올 때 호출
    public String home() {
        return "home";
    }

}
