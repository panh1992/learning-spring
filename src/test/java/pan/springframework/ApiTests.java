package pan.springframework;

import org.junit.jupiter.api.Test;
import pan.springframework.bean.UserService;
import pan.springframework.beans.factory.config.BeanDefinition;
import pan.springframework.beans.factory.support.DefaultListableBeanFactory;

class ApiTests {

    @Test
    void test_BeanFactory() {
        // 1、初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();

    }

}