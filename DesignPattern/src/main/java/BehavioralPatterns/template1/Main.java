package BehavioralPatterns.template1;

import org.junit.Test;

/**
 * 功能说明：观测者模式使用
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class Main {
    @Test
    public void testMain() {
        Subject subject = new ConcreteSubjectImpl();
        subject.addObserver(new ConcreteObserverA());
        subject.addObserver(new ConcreteObserverB());
        subject.notifyObservers(new Message());
    }
}
