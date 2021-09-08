package DP07_Observer.Example03_P2P_multiThread;

/**
 * 功能说明：模拟Service层的站内信业务
 * 开发人员：@author MaLi
 */
public class NotificationService {
    public void sendInboxMessage(long userId, String message) {
        System.out.println("尊敬的 " + userId + " 先生/女士 " + message);
    }
}
