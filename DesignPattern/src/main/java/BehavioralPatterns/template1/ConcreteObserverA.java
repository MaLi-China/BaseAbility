package BehavioralPatterns.template1;

/**
 * 功能说明：具体的观察者实现A
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class ConcreteObserverA implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverA is notifyed...");
    }
}
