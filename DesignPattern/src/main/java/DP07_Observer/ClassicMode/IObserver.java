package DP07_Observer.ClassicMode;

/**
 * 功能说明：观察者
 * 开发人员：@author MaLi
 */
public interface IObserver {
    /**
     * 观察者的动作
     *
     * @param message 接收到被观察者的状态消息
     */
    void doAction(Message message);
}
