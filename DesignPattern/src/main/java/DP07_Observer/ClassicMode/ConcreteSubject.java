package DP07_Observer.ClassicMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：具体的被观察者, 事件源, 分发者
 * 开发人员：@author MaLi
 */
public class ConcreteSubject implements ISubject {
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        //给所有的观察者, 发送Message
        for (IObserver observer : observers) {
            observer.doAction(message);
        }
    }
}
