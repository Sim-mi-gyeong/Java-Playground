package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// 레포지토리 : 엔티티 같은 것을 찾아주는 역할
@Repository   // 컴포넌트 스캔의 대상 -> 자동으로 스프링 빈에 등록
public class MemberRepository {

    @PersistenceContext   // 엔티티 매니저
    private EntityManager em;

    public Long save(MemberSub memberSub) {
        // Merge: Detached 상태(한 번이라도 영속화 되화지만, 현재는 영속화 되지 않은 상태인 Entity) 의 Entity 를 다시 영속화
        // Persist: 최초 생성된 Entity 를 영속
        em.persist(memberSub);
        return memberSub.getId();   // 커맨드와 쿼리를 분리하기 위함(id 정도만 조회)
    }

    public MemberSub find(Long id) {
        return em.find(MemberSub.class, id);
    }



}
