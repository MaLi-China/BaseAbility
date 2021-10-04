package mchapter_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：创建线程的方式
 * 方式1: 继承Thread类
 * 方式2: 实现Runnable接口
 * 方式3: 实现自Runnable的匿名内部类, 本质和方式2一样
 * 方式4: Lambda表达式, 本质和方式2一样
 * 方式5: 线程池
 * <p>
 * 开发人员：@author MaLi
 */
public class T01_Thread {
    public static void main(String[] args) {
        Thread t1 = new T1();
        t1.start();

        Thread t2 = new Thread(new T2());
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " is running******");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-3");
        t3.start();

        Thread t4 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running################");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-4");
        t4.start();

        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " is running-------------------->");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private static class T1 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class T2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running~~~");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
