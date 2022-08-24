package pan.springframework;

import org.junit.jupiter.api.Test;
import pan.springframework.bean.IUserService;
import pan.springframework.context.support.ClassPathXmlApplicationContext;

class ApiTests {

    @Test
    void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}