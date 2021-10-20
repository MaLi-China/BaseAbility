package C01_Thread;

/**
 * 功能说明：同步控制
 * 开发人员：@author MaLi
 */
public class T05_Synchronized {
    private final byte[] lock = {1};

    // 同步方法
    public synchronized void method() {
        System.out.println("critical area");
    }

    // 同步方法
    public synchronized static void staticMethod() {
        System.out.println("critical area");
    }

    // 同步代码块: 粒度可控
    public void method_synBlock() {
        synchronized (T05_Synchronized.class) {
            System.out.println("some1");
        }
        synchronized (lock) {
            System.out.println("some2");
        }
    }
}
