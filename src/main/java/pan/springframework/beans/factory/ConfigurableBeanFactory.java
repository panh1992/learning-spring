package pan.springframework.beans.factory;

import pan.springframework.beans.factory.config.BeanPostProcessor;
import pan.springframework.beans.factory.config.SingletonBeanRegistry;
import pan.springframework.util.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    /**
     * 为嵌入值（例如注释属性）添加字符串解析器
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * 解析给定的嵌入值，例如注释属性
     */
    String resolveEmbeddedValue(String value);

}
