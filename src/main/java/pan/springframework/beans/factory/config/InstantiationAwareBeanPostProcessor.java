package pan.springframework.beans.factory.config;

import pan.springframework.beans.BeansException;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * <i>在目标 bean 实例化之前应用此 BeanPostProcessor</i>。
     * 返回的 bean 对象可能是要使用的代理，而不是目标 bean，有效地抑制了目标 bean 的默认实例化
     * 在 Bean 对象执行初始化方法之前，执行此方法
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
