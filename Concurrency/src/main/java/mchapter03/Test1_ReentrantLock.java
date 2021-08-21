package mchapter03;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试可重入锁
 * 问题1:为什么synchronized要是可重入的
 * 开发人员：@Author MaLi
 */
public class Test1_ReentrantLock {
    public synchronized void method1() {
        try {
            System.out.println("method1 in");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("method1 out");
            System.out.println("ThreadName:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void method2() {
        try {
            System.out.println("method2 in");
            this.method1();
            TimeUnit.SECONDS.sleep(5);
            System.out.println("method2 out");
            System.out.println("ThreadName:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test1_ReentrantLock obj = new Test1_ReentrantLock();
        //不是同一个线程, 必须需要进入等待锁队列
        /*new Thread(obj::method1, "Thread1").start();
        new Thread(obj::method2, "Thread1").start();*/

        //假如是同一个线程
        new Thread(obj::method2, "Thread1").start();
    }
}
