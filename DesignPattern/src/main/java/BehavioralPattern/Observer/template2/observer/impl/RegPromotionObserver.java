package BehavioralPattern.Observer.template2.observer.impl;

import BehavioralPattern.Observer.template2.observer.RegObserver;
import BehavioralPattern.Observer.template2.service.PromotionService;

/**
 * 功能说明：观察者 - 促销活动观察者
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
