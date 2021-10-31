package Chapter04;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T03_Stack_deadLock {
    private static final byte[] lock1 = {1};
    private static final byte[] lock2 = {1};

    public static void main(String[] args) {
        Thread T1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("T1 is running...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("T1: do nothing...");
                }
            }
        }, "T1");

        Thread T2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("T2 is running...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("T2: do nothing...");
                }
            }
        }, "T2");

        try {
            T1.start();
            T2.start();
            T1.join();
            T2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
