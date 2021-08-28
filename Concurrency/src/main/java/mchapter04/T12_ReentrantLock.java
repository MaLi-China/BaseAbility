package mchapter04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：测试ReentrantLock比synchronized的优势
 * 对比使用synchronized与ReentrantLock两种方式, 当前线程被中断后, 是否会响应中断, 进而允许我们手动释放锁
 * 开发人员：@Author MaLi
 */
public class T12_ReentrantLock extends ReentrantLock {

    //测试synchronized是否能响应中断
    public void testSynchronized(T12_ReentrantLock other) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " 获取到一把锁");
            //睡眠一段时间, 保证线程2启动并获取到第一把锁
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 和ReentrantLock的区别是: 使用synchronized方式不会自动释放锁
                // 进入死锁阻塞后, 甚至我们也没有办法捕获InterruptedException异常, 即使捕获异常也没有办法手动释放锁
            }
            synchronized (other) {
                System.out.println(Thread.currentThread().getName() + " 获取到两把锁");
            }
        }
    }

    //测试ReentrantLock是否能响应中断
    public void testReentrantLock(T12_ReentrantLock other) {
        try {
            // 获取第一把锁
            this.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " 获取到一把锁");
            //睡眠一段时间, 保证线程2启动并获取到第一把锁
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取第二把锁
            other.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " 获取到两把锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
            // 和synchronized方式的区别, 如果进入死锁阻塞后, 我们可以在外界Interrupted当前线程
            // 在这里就可以捕获到异常, 手动释放锁
            // 锁被释放后, 另一个线程就可以获取到当前线程本来持有的锁
            this.unlock(); // 释放当前线程持有的锁
        }
    }

    public static void main(String[] args) {
        T12_ReentrantLock instance1 = new T12_ReentrantLock();
        T12_ReentrantLock instance2 = new T12_ReentrantLock();
        //测试synchronized
        /* 输出结果试验结果
            Thread_01 获取到一把锁
            Thread_02 获取到一把锁
            interrupt thread_01
         */
//        Thread thread_01 = new Thread(() -> instance1.testSynchronized(instance2), "Thread_01");
//        Thread thread_02 = new Thread(() -> instance2.testSynchronized(instance1), "Thread_02");

        //测试ReentrantLock
        /* 输出结果试验结果
            Thread_01 获取到一把锁
            Thread_02 获取到一把锁
            interrupt thread_01
            Thread_02 获取到两把锁    <--  这里在Thread_01释放掉持有的第一把锁后, Thread_02获取到了第二把锁.
            java.lang.InterruptedException
                at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireInterruptibly(AbstractQueuedSynchronizer.java:898)
                at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1222)
                at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:335)
                at mchapter04.T12_ReentrantLock.testReentrantLock(T12_ReentrantLock.java:43)
                at mchapter04.T12_ReentrantLock.lambda$main$0(T12_ReentrantLock.java:69)
                at java.lang.Thread.run(Thread.java:748)
         */
        Thread thread_01 = new Thread(() -> instance1.testReentrantLock(instance2), "Thread_01");
        Thread thread_02 = new Thread(() -> instance2.testReentrantLock(instance1), "Thread_02");

        thread_01.start();
        thread_02.start();
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("interrupt thread_01");
            thread_01.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
