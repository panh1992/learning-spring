package pan.springframework.context.annotation;

import cn.hutool.core.text.CharSequenceUtil;
import pan.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import pan.springframework.beans.factory.config.BeanDefinition;
import pan.springframework.beans.factory.support.BeanDefinitionRegistry;
import pan.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

/**
 * 一个 bean 定义扫描器，用于检测类路径上的 bean 候选者，
 * 使用给定的注册表注册相应的 bean 定义（{@code BeanFactory} 或 {@code ApplicationContext})
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private final BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (CharSequenceUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }

        // 注册处理注解的 BeanPostProcessor（@Autowired、@Value）
        registry.registerBeanDefinition("pan.springframework.context.annotation.internalAutowiredAnnotationProcessor",
                new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (Objects.nonNull(scope)) {
            return scope.value();
        }
        return CharSequenceUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (CharSequenceUtil.isEmpty(value)) {
            value = CharSequenceUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }


}
