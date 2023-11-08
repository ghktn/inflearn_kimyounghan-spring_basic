package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        /**
         * 위처럼 요청할 때마다 객체가 생성되면 JVM에 요청마다 객체가 생성이 되는 것은 효율적이지 않다.
         *
         * 해결방법 : 객체를 딱 하나만 생성해두고 공유해서 쓰자 (싱글톤 패턴 활용)
         */

        // memberService1은 memberService2와 달라야 한다.
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }
}
