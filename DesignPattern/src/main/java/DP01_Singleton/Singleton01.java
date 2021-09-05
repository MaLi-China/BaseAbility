package DP01_Singleton;

/**
 * 功能说明：饿汉式
 * 1, 私有化构造函数;
 * 2, 对外提供获取该对象的方法;
 * <p>
 * 开发人员：@author MaLi
 */
public class Singleton01 {
    private static final Singleton01 instance = new Singleton01();

    /*static {
        instance = new Singleton01();
    }*/

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return instance;
    }
}
