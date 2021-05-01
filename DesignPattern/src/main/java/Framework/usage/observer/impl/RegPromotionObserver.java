package Framework.usage.observer.impl;

import BehavioralPattern.Observer.template2.service.PromotionService;
import Framework.EventBus.Subscribe;
import Framework.usage.observer.RegObserver;

/**
 * 功能说明：观察者 - 促销活动观察者
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;

    @Subscribe
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("userId: " + userId);
        promotionService.issueNewUserExperienceCash(userId);

    }
}
