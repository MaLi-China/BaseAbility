package proxy.bean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class ProxyFactory {
    private static SpecificAction specificAction;

    static {
        specificAction = new SpecificAction();
    }

    public static IAction getJDKProxy() {
        return (IAction) Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), SpecificAction.class.getInterfaces(), (proxy, method, args) -> {
            System.out.println("jdkProxy before");
            method.invoke(specificAction, args);
            System.out.println("jdkProxy after");
            return null;
        });
    }


    public static IAction getCglibProxy() {
        return (IAction) Enhancer.create(SpecificAction.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

                System.out.println("cglibProxy before");
                method.invoke(specificAction, args);
                System.out.println("cglibProxy after");
                return null;
            }
        });
    }
}
