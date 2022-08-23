package pan.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import pan.springframework.beans.BeansException;
import pan.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.util.Objects;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (Objects.isNull(ctor)) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }

}
