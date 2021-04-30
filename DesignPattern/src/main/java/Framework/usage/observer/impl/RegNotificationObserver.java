package Framework.usage.observer.impl;

import BehavioralPatterns.ObserverDesignPattern.template2.service.NotificationService;
import Framework.EventBus.Subscribe;
import Framework.usage.observer.RegObserver;

/**
 * 功能说明：观察者实现 - 负责通知
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService;

    @Subscribe
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("userid: " + userId);
        notificationService.sendInboxMessage(userId, "some message..." + userId);
    }
}
