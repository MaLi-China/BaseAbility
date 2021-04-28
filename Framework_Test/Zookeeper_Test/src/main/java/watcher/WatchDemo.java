package watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author MaLi
 */
public class WatchDemo implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        watchedEvent.getState();
    }

    @Test
    public void testMethods() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User) context.getBean("user");
        user.hello();
    }
}
