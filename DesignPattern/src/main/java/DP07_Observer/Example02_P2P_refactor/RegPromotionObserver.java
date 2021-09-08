package DP07_Observer.Example02_P2P_refactor;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class RegPromotionObserver implements IRegObserver {
    private PromotionService promotionService; //依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        //处理行为
        promotionService.issueNewUserExperienceCash(userId);
    }
}
