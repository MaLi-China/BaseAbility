package DP07_Observer.Example02_P2P_refactor;

/**
 * 功能说明：观察者
 * 开发人员：@author MaLi
 */
public interface IRegObserver {
    //处理注册成功之后的Action
    void handleRegSuccess(long userId);
}
