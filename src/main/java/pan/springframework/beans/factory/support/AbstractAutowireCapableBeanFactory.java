package pan.springframework.beans.factory.support;

import pan.springframework.beans.BeansException;
import pan.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;

        try {
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException
                 | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

}
