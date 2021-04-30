package BehavioralPatterns.template1;

/**
 * 功能说明：观察者设计模式 - 观察者
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public interface Observer {

    /**
     * 在主题中被调用: 接收通知, 执行动作
     *
     * @param message 通知
     */
    void update(Message message);
}
