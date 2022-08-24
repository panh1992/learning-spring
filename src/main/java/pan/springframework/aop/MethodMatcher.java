package pan.springframework.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {

    /**
     * 执行静态检查给定方法是否匹配
     */
    boolean matches(Method method, Class<?> targetClass);

}
