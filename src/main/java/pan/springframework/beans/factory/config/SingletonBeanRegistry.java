package pan.springframework.beans.factory.config;

/**
 * 单例bean注册
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
