package pan.springframework.aop;

/**
 * 由切入点驱动的所有顾问的超级接口。
 * 这几乎涵盖了除介绍顾问之外的所有顾问，方法级别匹配不适用
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * 获取驱动的切入点
     */
    Pointcut getPointcut();

}
