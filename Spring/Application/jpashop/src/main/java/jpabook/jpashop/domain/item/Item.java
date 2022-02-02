package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // SINGLE_TABLE: 한 테이블에 다 넣기 cf) type 중 JOINED 는 가장 정규화된 방법
@DiscriminatorColumn(name = "dtype")   // book 이면 어떻게 하고 ..
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    // 상속관계 매핑

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // == 비즈니스 로직 == //
    /**
     * stack 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    /**
     * stack 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
