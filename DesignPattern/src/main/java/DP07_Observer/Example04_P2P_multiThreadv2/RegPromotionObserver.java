package DP07_Observer.Example04_P2P_multiThreadv2;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class RegPromotionObserver implements IRegObserver {
    private PromotionService promotionService = new PromotionService(); //依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        //处理行为
        // 这里有问题: 频繁的创建线程, 耗时, 其次, 可能导致堆栈溢出.  (这里只用来说明问题, 实际生产不能这样使用.)
        new Thread(() -> promotionService.issueNewUserExperienceCash(userId), "Thread_RegPromotionObserver").start();
    }
}
