package BehavioralPatterns.ObserverDesignPattern.template1;

import java.util.ArrayList;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class ConcreteSubjectImpl implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
