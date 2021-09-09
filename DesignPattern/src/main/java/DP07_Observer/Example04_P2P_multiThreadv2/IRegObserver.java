package DP07_Observer.Example04_P2P_multiThreadv2;

/**
 * 功能说明：观察者
 * 开发人员：@author MaLi
 */
public interface IRegObserver {
    //处理注册成功之后的Action
    void handleRegSuccess(long userId);
}
