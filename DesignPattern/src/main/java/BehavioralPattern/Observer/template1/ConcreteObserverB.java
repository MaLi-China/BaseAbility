package BehavioralPattern.Observer.template1;

/**
 * 功能说明：具体的观察者实现B
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class ConcreteObserverB implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverB is notifyed...");
    }
}
