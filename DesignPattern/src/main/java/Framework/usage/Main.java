package Framework.usage;

import Framework.EventBus.EventBus;
import Framework.usage.observer.RegObserver;
import Framework.usage.observer.impl.RegNotificationObserver;
import Framework.usage.observer.impl.RegPromotionObserver;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class Main {
    private EventBus eventBus = new EventBus();

    public void setObserver(List<RegObserver> observers) {
        for (RegObserver observer : observers) {
            eventBus.register(observer.getClass());
        }
    }

    public void register() {
        System.out.println("注册业务完成");
        eventBus.post(1);
    }

    @Test
    public void testMain() {
        List<RegObserver> regObservers = new ArrayList<>();
        regObservers.add(new RegNotificationObserver());
        regObservers.add(new RegPromotionObserver());
        setObserver(regObservers);
        register();
    }
}
