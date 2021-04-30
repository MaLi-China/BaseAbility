package Framework.EventBus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 功能说明：阻塞同步的观察者模式
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    /**
     * 注册观察者
     *
     * @param object 事件类型
     */
    public void register(Object object) {
        registry.register(object);
    }

    /**
     * 发送通知
     *
     * @param event 观察者的函数接收的参数
     */
    public void post(Object event) {
        // 1, 获取符合条件的通知方法
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);

        // 2, 运行通知
        for (ObserverAction observerAction : observerActions) {
            executor.execute(() -> observerAction.execute(event));
        }
    }
}
