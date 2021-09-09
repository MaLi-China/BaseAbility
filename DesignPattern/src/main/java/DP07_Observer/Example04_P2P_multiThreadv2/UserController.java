package DP07_Observer.Example04_P2P_multiThreadv2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * 功能说明：模拟Controller层的注册
 * --不用观察者的情况
 * 开发人员：@author MaLi
 */
public class UserController {
    // 以下两个属性, 通过Spring注入
    private UserService userService = new UserService(); //这里模拟, 直接New
    //    private PromotionService promotionService;
    private List<IRegObserver> regObservers = new ArrayList<>();
    private Executor executor; // 注入线程池

    public void setRegObservers(List<IRegObserver> regObservers) {
        this.regObservers.addAll(regObservers);
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
        for (IRegObserver regObserver : regObservers) {
            //在这里使用线程池还有点瑕疵, 就是该类与线程池耦合在一起
            executor.execute(() -> regObserver.handleRegSuccess(userId));
        }
        return userId;
    }
}
