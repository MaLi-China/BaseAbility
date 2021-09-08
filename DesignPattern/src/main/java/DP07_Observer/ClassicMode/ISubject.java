package DP07_Observer.ClassicMode;

/**
 * 功能说明：代表被观察者, 事件发出者, 生产者, 分发模型
 * Subject, EventEmitter, Producer, Dispatcher
 * 开发人员：@author MaLi
 */
public interface ISubject {
    /**
     * 注册观察者
     *
     * @param observer 观察者
     */
    void registerObserver(IObserver observer);

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(IObserver observer);

    /**
     * 给所有观察者发送通知
     *
     * @param message 发送给观察者的消息
     */
    void notifyObservers(Message message);
}
