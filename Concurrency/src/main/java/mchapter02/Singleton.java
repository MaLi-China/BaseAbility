package mchapter02;

/**
 * 功能说明：单例模式
 * 开发人员：@Author MaLi
 */
public class Singleton {
    //饿汉式
//    private static Singleton instance = new Singleton();
    //懒汉式
    private static Singleton instance = null;

    public Singleton() {

    }

    // 保证线程安全的写法
    public synchronized static Singleton getInstance1() {
        // 性能问题: 即使已经创建过instance, 还是要在进入方法前进行排队, 获取锁
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // 继续改进: 加锁粒度太大, 影响性能, 如何提升一下
    public static Singleton getInstance2() {
        //改进性能: 如果instance已经被创建过, 直接跳过该if代码块
        if (instance == null) {
            // 逻辑问题: 如果instance没有创建, 多个线程同时进入该代码块, 最后会创建多个实例出来
            synchronized (Singleton.class) {
                //线程安全问题:
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static Singleton getInstance3() {
        //双重检查锁机制, 改进性能: 如果instance已经被创建过, 直接跳过该if代码块
        if (instance == null) {
            // 逻辑问题: 如果instance没有创建, 多个线程同时进入该代码块, 最后会创建多个实例出来
            synchronized (Singleton.class) {
                //重新进行一次非空判断, 其它线程获取到锁后,发现instance已经创建, 直接返回了.
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
