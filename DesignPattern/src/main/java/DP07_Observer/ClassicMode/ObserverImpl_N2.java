package DP07_Observer.ClassicMode;

/**
 * 功能说明：具体的观察者模拟
 * 开发人员：@author MaLi
 */
public class ObserverImpl_N2 implements IObserver {
    @Override
    public void doAction(Message message) {
        System.out.println(this.getClass().getSimpleName() + " : " + message);
    }
}
