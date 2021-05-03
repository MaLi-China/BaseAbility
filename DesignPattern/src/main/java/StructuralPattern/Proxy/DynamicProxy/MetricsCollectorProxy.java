package StructuralPattern.Proxy.DynamicProxy;

import StructuralPattern.Proxy.IUserController;
import StructuralPattern.Proxy.StaticProxy.MetricsCollector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能说明：动态代理的方式, 实现为任意类添加性能指标收集功能
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/3
 */
public class MetricsCollectorProxy {
    public IUserController createProxy(Object proxiedObject) {
        MetricsCollector metricsCollector = new MetricsCollector();
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        return (IUserController) Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1,  do some metrics colletion...

                        //2, 委托
                        Object result = method.invoke(proxiedObject, args);

                        //3, do some metrics colletion...

                        //4, collect metrics into some object
                        metricsCollector.recordRequest(new Object());

                        return result;
                    }
                });
    }
}
