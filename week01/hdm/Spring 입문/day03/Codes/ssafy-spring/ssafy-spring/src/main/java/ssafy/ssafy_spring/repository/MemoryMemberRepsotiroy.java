package ssafy.ssafy_spring.repository;

import org.springframework.stereotype.Repository;
import ssafy.ssafy_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepsotiroy implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 8L;

    @Override
    public Member save(Member member) {

        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
