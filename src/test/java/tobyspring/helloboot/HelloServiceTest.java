package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
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
