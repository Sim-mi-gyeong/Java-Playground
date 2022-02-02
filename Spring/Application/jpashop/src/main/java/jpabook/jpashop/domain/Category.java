package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",   // 중간 테이블 매핑
            joinColumns = @JoinColumn(name = "category_id"),   // 중간 테이블에 있는 category_id
            inverseJoinColumns = @JoinColumn(name = "item_id"))    // Category 테이블에서 Item 쪽으로 들어가는,
    // 객체는 collection / collection 이 있어 다대다 관계 가능
    // 관계형 DB 는 컬렉션 관계를 양쪽이 가질 수 없어 -> 일대다 / 다대일로 풀어내는 중간 테이블이 필요
    private List<Item> items = new ArrayList<>();   // 카테고리도 리스트로 아이템을 가지고, 아이템도 리스트로 카테고리를 가짐

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    // 자식은 여러 개 가능
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
