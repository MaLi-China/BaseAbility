package BehavioralPattern.Observer.template1;

/**
 * 功能说明：观察者设计模式 - 主题(被观察者)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public interface Subject {
    /**
     * 添加观察者到集合
     *
     * @param observer 具体观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除传递的观察者
     *
     * @param observer 具体观察者
     */
    void removeObserver(Observer observer);

    /**
     * 给所有观察者发送通知
     *
     * @param message 通知对象
     */
    void notifyObservers(Message message);
}
