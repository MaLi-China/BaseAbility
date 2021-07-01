package jvmv3.chapter02_04_03;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 功能说明： 测试方法区的OOM
 * 测试逻辑: 不断放入类
 * 方法区: 用于存放类信息(类名, 访问修饰符, 常量池(jdk7开始放入到堆内存中), 字段描述, 方法描述)
 * 开发人员：@Author MaLi
 */
public class JavaMethodAreaOOM {
    //jdk7版本: 永久代实现
    //-XX:PermSize=10M -XX:MaxPermSize=10M

    //JDK8版本: metaspace实现, 直接使用机器内存
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OOMObject.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                return proxy.invoke(obj, args);
            }
        });
        enhancer.create();
    }

    static class OOMObject {
        //用于占用空间的类, 填满方法区
    }
}
