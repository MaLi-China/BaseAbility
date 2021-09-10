package DP01_Singleton.base;

/**
 * 功能说明：懒汉式
 * 需要的时候才创建
 * 开发人员：@author MaLi
 */
public class Singleton02 {
    private static volatile Singleton02 instance;

    private Singleton02() {

    }

    public static Singleton02 getInstance() {
        if (instance == null) {
            synchronized (Singleton02.class) {
                if (instance == null) {
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }
}
