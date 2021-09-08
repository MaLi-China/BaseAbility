package DP07_Observer.ClassicMode;

/**
 * 功能说明: 模拟客户端使用观察者设计模式
 * 开发人员：@author MaLi
 */
public class Main {
    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();           //注入
        subject.registerObserver(new ObserverImpl_N1());    //注入
        subject.registerObserver(new ObserverImpl_N2());    //注入
        Message message = new Message();                    //注入
        subject.notifyObservers(message);
    }
}
