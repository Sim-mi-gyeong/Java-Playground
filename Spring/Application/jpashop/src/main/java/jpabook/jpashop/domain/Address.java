package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable   // 어딘가에 내장될 수 있음을 의미
@Getter   // 값 타입은 기본적으로, 값의 변경이 불가해야 함(immutable 하게 설계되어야 함)
public class Address {   // JPA 의 내장 타입

    private String city;
    private String street;
    private String zipcode;

    protected Address() {   // public 으로 하면 사람들이 호출을 많이 할 가능성 O

    }

    public Address(String city, String street, String zipcode) {   // 생성할 때에만 값이 세팅, Setter 제공 X
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
