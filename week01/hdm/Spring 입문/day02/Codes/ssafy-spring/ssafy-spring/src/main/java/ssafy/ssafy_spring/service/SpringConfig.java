package ssafy.ssafy_spring.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ssafy.ssafy_spring.repository.*;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired // 생성자 하나면 생략 가능.
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository() {
//// return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }

}