package pan.springframework.aop.aspectj;

import org.aopalliance.aop.Advice;
import pan.springframework.aop.Pointcut;
import pan.springframework.aop.PointcutAdvisor;

import java.util.Objects;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;

    // 具体的拦截方法
    private Advice advice;

    // 表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (Objects.isNull(pointcut)) {
            this.pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
