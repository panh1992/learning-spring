package pan.springframework.beans.factory;

import pan.springframework.beans.BeansException;

/**
 * 定义一个可以返回 Object 实例的工厂（可能是共享的或独立的）调用时
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
