package pan.springframework.context.event;

import pan.springframework.context.ApplicationEvent;
import pan.springframework.context.ApplicationListener;

/**
 * 事件广播器
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加一个侦听器以接收所有事件的通知
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 从通知列表中删除监听器
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的应用程序事件多播到适当的侦听器
     */
    void multicastEvent(ApplicationEvent event);

}
