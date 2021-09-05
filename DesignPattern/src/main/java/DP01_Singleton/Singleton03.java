package DP01_Singleton;

/**
 * 功能说明：使用内部类的方式, JVM保证Class只被加载一次, 同时保证线程安全
 * 内部类只有在使用的时候才会被JVM加载.且只被加载一次
 * 开发人员：@author MaLi
 */
public class Singleton03 {
    private static Singleton03 instance;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private final static Singleton03 instance = new Singleton03();
    }
}
