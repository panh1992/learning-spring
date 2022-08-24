package pan.springframework.aop;

import pan.springframework.util.ClassUtils;

/**
 * 被代理的目标对象
 * 用于获取 AOP 调用的当前“目标”，如果没有环绕通知选择结束拦截器链本身，则将通过反射调用该目标
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object object) {
        this.target = object;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return target;
    }

}
