package DP07_Observer.EventBus;

import java.lang.reflect.Method;

/**
 * 功能说明：被@Subscribe注解的方法
 * 开发人员：@author MaLi
 */
public class ObserverAction {
    private Object observer;
    private Method method;

    public ObserverAction(Object observer, Method method) {
        this.observer = observer;
        this.method = method;
    }
}
