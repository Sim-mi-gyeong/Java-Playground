package com.example.hellospring.domain;

public class Member {
    private Long id;   // id는 시스템이 직접 지정
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
