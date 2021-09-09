package DP07_Observer.Example03_P2P_multiThread;

/**
 * 功能说明：模拟注册成功的站内信发送观察者
 * 开发人员：@author MaLi
 */
public class RegNotificationObserver implements IRegObserver {
    private NotificationService notificationService = new NotificationService();

    @Override
    public void handleRegSuccess(long userId) {
        // 这里有问题: 频繁的创建线程, 耗时, 其次, 可能导致堆栈溢出.  (这里只用来说明问题, 实际生产不能这样使用.)
        new Thread(() -> notificationService.sendInboxMessage(userId, "Welcome..."), "Thread_RegNotificationObserver").start();
    }
}
