package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않아 -> 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤 -> private 로 생성자 막기
    private MemberRepository() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store 에 있는 모든 값들을 꺼내 -> 새로운 ArrayList 에 넣어
        // ->ArrayList 에 있는 값을 넣거나, 밖에서 조작해도 store 의 value 를 건들지 않기 위함
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}