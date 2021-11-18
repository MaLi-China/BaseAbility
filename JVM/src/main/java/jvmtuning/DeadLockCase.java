package jvmtuning;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：死锁用例
 * 开发人员：@author MaLi
 */
public class DeadLockCase {
    public static void main(String[] args) {
        byte[] lock1 = new byte[]{};
        byte[] lock2 = new byte[]{};
        System.out.println("main is running...");
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("t1 is running...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("T1-Thread can not reach here");
                }
            }
        }, "Thread-T1");
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("t2 is running...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("T2-Thread can not reach here");
                }
            }
        }, "Thread-T2");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
