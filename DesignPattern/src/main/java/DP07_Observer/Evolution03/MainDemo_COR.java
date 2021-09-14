package DP07_Observer.Evolution03;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：使用观察者
 * 开发人员：@author MaLi
 */
public class MainDemo_COR {
    static class Child {
        private boolean isCry = false;
        private ObserversChain observersChain;

        public Child(ObserversChain observersChain) {
            this.observersChain = observersChain;
        }

        public void cry() {
            this.isCry = true;
            System.out.println("Baby is crying...");
            observersChain.appease(this, observersChain);
        }
    }

    static interface Observer {
        boolean appease(Child child, ObserversChain observersChain);
    }

    static class ObserversChain implements Observer {
        private List<Observer> observers = new ArrayList<>();
        private int index = 0;

        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        public void remove(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public boolean appease(Child child, ObserversChain observersChain) {
            for (Observer observer : observersChain.observers) {
                if (index == observers.size()) {
                    return false;
                }
                Observer nextObserver = observersChain.observers.get(index++);
                boolean goOnAppease = nextObserver.appease(child, observersChain);
                if (!goOnAppease) {
                    return false;
                }
            }
            return false;
        }
    }

    static class Dad implements Observer {
        @Override
        public boolean appease(Child child, ObserversChain observersChain) {
            System.out.println("Dad is appeasing...");
            child.isCry = false;
            observersChain.appease(child, observersChain);
            return false;
        }
    }

    static class GrandMa implements Observer {
        public boolean appease(Child child, ObserversChain observersChain) {
            System.out.println("Mum is appeasing...");
            child.isCry = false;
            observersChain.appease(child, observersChain);
            return true;
        }
    }

    static class Mum implements Observer {
        public boolean appease(Child child, ObserversChain observersChain) {
            System.out.println("GrandMa is appeasing...");
            child.isCry = false;
            observersChain.appease(child, observersChain);
            return true;
        }
    }

    public static void main(String[] args) {
        ObserversChain observersChain = new ObserversChain();
        Dad dad = new Dad();
        Mum mum = new Mum();
        GrandMa grandMa = new GrandMa();
        observersChain.addObserver(dad);
        observersChain.addObserver(mum);
        observersChain.addObserver(grandMa);
        Child child = new Child(observersChain);
        child.cry();
    }
}
