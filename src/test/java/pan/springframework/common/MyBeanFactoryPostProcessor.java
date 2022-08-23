package pan.springframework.common;

import pan.springframework.beans.BeansException;
import pan.springframework.beans.PropertyValue;
import pan.springframework.beans.PropertyValues;
import pan.springframework.beans.factory.ConfigurableListableBeanFactory;
import pan.springframework.beans.factory.config.BeanDefinition;
import pan.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
