package com.example.hellospring.controller;

public class MemberForm {

    private String name;   // 이곳의 name 으로 form 에서 입력한 'spring' 이라는 값이 setName(String name)을 통해 들어옴

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
