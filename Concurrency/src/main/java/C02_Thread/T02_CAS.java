package C02_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能说明：
 * volatile的作用
 * 原子类的使用
 * 开发人员：@author MaLi
 */
public class T02_CAS {
    private static volatile int i1 = 0;
    private static AtomicInteger i2 = new AtomicInteger(0);

    /*public void m1() {
        for (int i = 0; i < 10000; i++) {
            i1++;
        }
    }*/
    public void m1() {
        //同步代码块加锁, 保证数据安全
        synchronized (T02_CAS.class) {
            for (int i = 0; i < 10000; i++) {
                i1++;
            }
        }
    }

    public void m2() {
        for (int i = 0; i < 10000; i++) {
            i2.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(() -> {
                T02_CAS obj = new T02_CAS();
                obj.m1();
            });
            Thread thread2 = new Thread(() -> {
                T02_CAS obj = new T02_CAS();
                obj.m2();
            });
            threads.add(thread1);
            threads.add(thread2);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);

    }
}
