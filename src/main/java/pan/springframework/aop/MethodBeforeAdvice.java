package pan.springframework.aop;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends BeforeAdvice {

    /**
     * 调用给定方法之前的回调
     *
     * @param method 被调用的方法
     * @param args   方法的参数
     * @param target 方法调用的目标。可能是 <code>null</code>
     * @throws Throwable 如果此对象希望中止调用。如果方法签名允许，任何抛出的异常都将返回给调用者。
     *                   否则异常将被包装为运行时异常
     */
    void before(Method method, Object[] args, Object target) throws Throwable;

}
