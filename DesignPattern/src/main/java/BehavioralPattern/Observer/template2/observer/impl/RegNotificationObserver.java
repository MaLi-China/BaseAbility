package BehavioralPattern.Observer.template2.observer.impl;

import BehavioralPattern.Observer.template2.observer.RegObserver;
import BehavioralPattern.Observer.template2.service.NotificationService;

/**
 * 功能说明：观察者实现 - 负责通知
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService;

    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "some message...");
    }
}
