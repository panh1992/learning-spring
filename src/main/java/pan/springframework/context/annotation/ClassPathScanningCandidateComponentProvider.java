package pan.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import pan.springframework.beans.factory.config.BeanDefinition;
import pan.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 从基础包扫描类路径的组件提供程序。
 * 然后它将排除和包含过滤器应用于结果类以查找候选者
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
