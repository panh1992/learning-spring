package pan.springframework.aop;

public interface ClassFilter {

    /**
     * 切入点是否应该应用于给定的接口或目标类
     */
    boolean matches(Class<?> clazz);

}
