package com.nengli51;

import java.lang.reflect.Method;

/**
 * 功能说明：检测性能指标的框架
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class TestCase {
    /**
     * 检测加了@TimeMetrics注解的方法时间性能
     *
     * @param clazz 需要检测性能指标的类
     */
    public static void run(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            boolean present = method.isAnnotationPresent(TimeMetrics.class);
            if (present) {
                try {
                    long start = System.currentTimeMillis();
                    method.invoke(clazz.newInstance());
                    long end = System.currentTimeMillis();
                    System.out.println("Time wasted: " + method.getName() + " --> " + (end - start) + "ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
