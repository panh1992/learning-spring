package pan.springframework;

import org.junit.jupiter.api.Test;
import pan.springframework.bean.UserService;

import static org.junit.jupiter.api.Assertions.*;

class ApiTests {

    @Test
    void test_BeanFactory() {
        // 1、初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}