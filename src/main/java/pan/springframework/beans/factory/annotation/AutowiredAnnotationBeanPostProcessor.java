package pan.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import pan.springframework.beans.BeansException;
import pan.springframework.beans.PropertyValues;
import pan.springframework.beans.factory.BeanFactory;
import pan.springframework.beans.factory.BeanFactoryAware;
import pan.springframework.beans.factory.ConfigurableBeanFactory;
import pan.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import pan.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.util.Objects;

public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (ConfigurableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (Objects.nonNull(valueAnnotation)) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (Objects.nonNull(autowiredAnnotation)) {
                Class<?> fieldType = field.getType();
                Object dependentBean;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                if (Objects.nonNull(qualifierAnnotation)) {
                    dependentBean = beanFactory.getBean(qualifierAnnotation.value(), fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }
}
