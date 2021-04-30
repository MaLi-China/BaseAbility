package BehavioralPatterns.template2.service;

/**
 * 功能说明：业务类 - 负责向用户发送通知
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public interface NotificationService {
    /**
     * 模拟向用户发送消息
     *
     * @param userId 用户id
     * @param msg    消息内容
     */
    void sendInboxMessage(long userId, String msg);
}
