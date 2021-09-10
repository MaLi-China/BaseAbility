package DP07_Observer.EventBus;


import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 功能说明：注册了观察者的列表
 * <p>
 * 开发人员：@author MaLi
 */
public class ObserverRegistry {
    //注册表集合 <事件:列表<ObserverAction<类, 方法>>>
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    //1, 注册观察者 --> 事件--列表<ObserverAction<类, 方法>>
    public void register(Object observer) {
        // TODO - 并发工具类
        findAllObserverActions(observer);
    }
    //2, 获取对应事件的ObserverAction

    public List<ObserverAction> getObserverAction(Object event) {
        return null;
    }

    //3. 保存观察者类中所有的@Subscribe注解
    public Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        List<Method> methods = new ArrayList<>();
        getAnnotatedMethods(clazz, methods);
        for (Method method : methods) {
            //把Method保存到容器中去
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private void getAnnotatedMethods(Class<?> clazz, List<Method> methods) {
        //遍历所有方法, 检测是否有注解, 有注解--> 放入到集合中
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //1.检查是否有指定的注解
            if (method.isAnnotationPresent(Subscribe.class)) {
                int parameterCount = method.getParameterCount();
                Class<?>[] parameterTypes = method.getParameterTypes();
                //2, 检查该方法是否有正确的参数个数与类型 --> 如果有问题, 抛出异常
                Preconditions.checkArgument(parameterCount == 1, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", method, parameterCount);
                //符合条件的方法, 加入到集合中
                methods.add(method);
            }
        }
    }
}
