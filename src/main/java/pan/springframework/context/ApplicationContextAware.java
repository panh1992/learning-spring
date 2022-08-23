package pan.springframework.context;

import pan.springframework.beans.BeansException;
import pan.springframework.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
