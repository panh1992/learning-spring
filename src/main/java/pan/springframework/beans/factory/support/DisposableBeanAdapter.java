package pan.springframework.beans.factory.support;

import cn.hutool.core.text.CharSequenceUtil;
import pan.springframework.beans.BeansException;
import pan.springframework.beans.factory.DisposableBean;
import pan.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;
import java.util.Objects;

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean disposableBean) {
            disposableBean.destroy();
        }

        // 2. 注解配置 destroy-method {判断是为了避免二次执行销毁}
        if (CharSequenceUtil.isNotEmpty(destroyMethodName)
                && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (Objects.isNull(destroyMethod)) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }

    }
}
