package pan.springframework.context.event;

import pan.springframework.beans.factory.BeanFactory;
import pan.springframework.context.ApplicationEvent;
import pan.springframework.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener<ApplicationEvent> listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
