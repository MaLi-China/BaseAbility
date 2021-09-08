package DP07_Observer.Example03_P2P_multiThread;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class RegPromotionObserver implements IRegObserver {
    private PromotionService promotionService = new PromotionService(); //依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        //处理行为
        new Thread(() -> promotionService.issueNewUserExperienceCash(userId), "Thread_RegPromotionObserver").start();
    }
}
