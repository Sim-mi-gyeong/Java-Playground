package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional   // 데이터를 변경하므로 Transactional 
    public Long order(Long memberId, Long itemId, int count) {
        
        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);
        
        // 배송정보 생성 -> 회원의 주소로 배송지 설정
        Delivery delivery = new Delivery();  
        delivery.setAddress(member.getAddress());
        
        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        
        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장 -> casecade 옵션으로 인해 OrderItem 과 Delivery 가 모두 persist 된다!
        orderRepository.save(order);   // 세팅할 때 옵션 중 casecade = CasecadeType.ALL -> order 를 persist 하면 OrderItem 컬렉션과 같이 들어와 있는 것을 모두 강제로 persist 해줌

        return order.getId();   // order 의 식별자 값 반환
        
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();

    }
    
    // 검색
/*
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
*/

}
