package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SingletonTest {
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1= SingletonService.getInstance();
        SingletonService singletonService2= SingletonService.getInstance();

        //isSameAs는 실제 instance를 비교
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1=ac.getBean("memberService", MemberService.class);
        MemberService memberService2=ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1=" + memberService1);
        System.out.println("memberService1=" + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
