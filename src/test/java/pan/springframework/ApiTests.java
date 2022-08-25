package pan.springframework;

import org.junit.jupiter.api.Test;
import pan.springframework.bean.Husband;
import pan.springframework.bean.Wife;
import pan.springframework.context.support.ClassPathXmlApplicationContext;

class ApiTests {

    @Test
    void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }


}