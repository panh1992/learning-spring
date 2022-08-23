package pan.springframework.beans.factory;

import pan.springframework.beans.BeansException;
import pan.springframework.beans.factory.config.AutowireCapableBeanFactory;
import pan.springframework.beans.factory.config.BeanDefinition;
import pan.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
