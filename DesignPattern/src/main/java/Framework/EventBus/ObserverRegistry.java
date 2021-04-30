package Framework.EventBus;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 功能说明：Observer 注册表
 * 包含所有注册进入的观察者
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class ObserverRegistry {
    // 用于存放类型: ObserverAction
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    /**
     * 注册观察者到注册表
     *
     * @param observer 观察者
     */
    public void register(Object observer) {
        // 1, 获取观察者的注解方法, 封装到注册表
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                CopyOnWriteArraySet<ObserverAction> value = new CopyOnWriteArraySet<>();
                registry.put(eventType, value);
                registeredEventActions = value;
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    /**
     * 获取匹配的方法
     *
     * @param event 事件类型
     * @return 返回封装了ObserverAction的列表
     */
    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> eventActions = entry.getValue();
            // isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。
            // isAssignableFrom()是在类的角度判断; instanceof是在实例的角度判断。
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    /**
     * 封装带有Subscribe注解的类为类Class<?>, Collection<ObserverAction>方式
     * 一个被观察者可能有多个观察者, 每一个观察者提供给被观察者一个函数(参数)
     * 于是: 参数类型:ObserverActionS
     *
     * @param observer 观察者
     * @return K:V = 参数类型: 存放ObserverAction集合
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        //用于存储返回结果: 事件类型: 观察者动作类(观察者, 方法)s <-- 一个事件类型对应多个观察者的方法, 所以使用一个集合保存
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> observerClass = observer.getClass();

        // 1, 获取注册观察者所有带注解的方法
        List<Method> annotatedMethods = getAnnotatedMethods(observerClass);
        // 2, 组装到map: key事件类型: value观察者动作类(观察者, 方法)s
        for (Method annotatedMethod : annotatedMethods) {
            // 获取方法参数类型
            Class<?>[] parameterTypes = annotatedMethod.getParameterTypes();
            // 获取第一个参数的类型
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, annotatedMethod));
        }
        return observerActions;
    }

    /**
     * 获取参数类上所有被添加了Subscribe注解的方法
     *
     * @param clazz 工具类
     * @return 带有Subscribe注解的方法集合
     */
    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        // 1, 获取所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        // 2, 过滤合规的方法: 带有注解, 事件类型参数长度为1
        for (Method method : methods) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                // 验证参数是否合规: 有且仅有一个函数参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                int parameterLength = parameterTypes.length;
                // 这里可能抛出异常: 检查参数是否合规
                Preconditions.checkArgument(parameterLength == 1, "Method %s has @Subscribe annotation but has %s parameters. " +
                        "Subscriber methods must have exactly 1 parameter.", method, parameterLength);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
