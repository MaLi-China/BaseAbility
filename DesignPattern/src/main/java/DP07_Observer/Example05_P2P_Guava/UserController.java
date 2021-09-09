package DP07_Observer.Example05_P2P_Guava;

import DP07_Observer.Example04_P2P_multiThreadv2.IRegObserver;
import DP07_Observer.Example04_P2P_multiThreadv2.UserService;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * 功能说明：模拟Controller层的注册
 * --不用观察者的情况
 * 开发人员：@author MaLi
 */
public class UserController {
    // 以下两个属性, 通过Spring注入
    private UserService userService = new UserService(); //这里模拟, 直接New
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
    }

    public void setRegObservers(List<IRegObserver> regObservers) {
        for (IRegObserver observer : regObservers) {
            eventBus.register(observer); //在客户端, 把所有的观察者注入到里面
        }
    }

    /**
     * 三层架构: Controller层
     *
     * @param telephone 电话
     * @param password  密码
     * @return userId userId
     */
    public Long register(String telephone, String password) {
        //注册
        long userId = userService.register(telephone, password);
        //推广活动:体 验 金(以后可能还有优惠券, 站内信)
        //未重构前的代码, 保留作为与观察者模式的对比.
        // promotionService.issueNewUserExperienceCash(userId);

        //不论未来是否有多少新的推广活动, 只需要在配置文件里面注入新的活动观察者即可, 符合开闭原则.
        //regObserver.handleRegSuccess(userId);
        eventBus.post(userId);
        return userId;
    }
}
