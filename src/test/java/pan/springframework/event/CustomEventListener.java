package pan.springframework.event;

import pan.springframework.context.ApplicationListener;

import java.time.LocalDateTime;

public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + LocalDateTime.now());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }

}
