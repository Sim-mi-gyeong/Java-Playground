package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")   // Orders 테이블에 있는 member 필드에 의해 매핑됨 -> 읽기 전용(이 값으로 인해 Foregin Key 값이 변경되지 않음)
    private List<Order> orders = new ArrayList<>();

}
