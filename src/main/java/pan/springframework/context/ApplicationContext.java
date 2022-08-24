package pan.springframework.context;

import pan.springframework.beans.factory.HierarchicalBeanFactory;
import pan.springframework.beans.factory.ListableBeanFactory;
import pan.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
