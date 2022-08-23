package pan.springframework;

import org.junit.jupiter.api.Test;
import pan.springframework.bean.UserService;
import pan.springframework.context.support.ClassPathXmlApplicationContext;

class ApiTests {

    @Test
    void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}