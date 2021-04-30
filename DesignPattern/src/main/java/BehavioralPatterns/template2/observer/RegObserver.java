package BehavioralPatterns.template2.observer;

/**
 * 功能说明：观察者接口
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public interface RegObserver {
    /**
     * 处理注册成功之后的动作
     *
     * @param userId 接收注册成功之后的用户id
     */
    void handleRegSuccess(long userId);
}
