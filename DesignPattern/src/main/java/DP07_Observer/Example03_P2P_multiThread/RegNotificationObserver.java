package DP07_Observer.Example03_P2P_multiThread;

/**
 * 功能说明：模拟注册成功的站内信发送观察者
 * 开发人员：@author MaLi
 */
public class RegNotificationObserver implements IRegObserver {
    private NotificationService notificationService = new NotificationService();

    @Override
    public void handleRegSuccess(long userId) {
        new Thread(() -> notificationService.sendInboxMessage(userId, "Welcome..."), "Thread_RegNotificationObserver").start();
    }
}
