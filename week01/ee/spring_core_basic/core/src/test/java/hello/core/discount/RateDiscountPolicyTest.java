package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    // RateDiscountPolicy가 정말 10% 할인이 되는 지를 테스트 하는 것
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    // 실패 테스트
//    @Test
//    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
//    void vip_x() {
//        //given
//        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
//        //when
//        int discount = discountPolicy.discount(member, 10000);
//        //then
//        assertThat(discount).isEqualTo(1000);
//    }
}