package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test
@interface UnitTest{
}

public class HelloServiceTest {
    @FastUnitTest
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();
        String hello = helloService.sayHello("Spring");

        Assertions.assertThat(hello).isEqualTo("Hello Spring");
    }

    @Test
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);
        String hello = helloService.sayHello("Spring");

        Assertions.assertThat(hello).isEqualTo("*Spring*");
    }
}
