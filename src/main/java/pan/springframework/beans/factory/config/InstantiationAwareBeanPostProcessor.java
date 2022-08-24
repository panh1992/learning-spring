package pan.springframework.beans.factory.config;

import pan.springframework.beans.BeansException;
import pan.springframework.beans.PropertyValues;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * <i>在目标 bean 实例化之前应用此 BeanPostProcessor</i>。
     * 返回的 bean 对象可能是要使用的代理，而不是目标 bean，有效地抑制了目标 bean 的默认实例化
     * 在 Bean 对象执行初始化方法之前，执行此方法
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * 在工厂将给定的属性值应用于给定的 bean 之前对其进行后处理。
     * 允许检查是否满足所有依赖项，例如基于 bean 属性设置器上的“必需”注释
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

}
