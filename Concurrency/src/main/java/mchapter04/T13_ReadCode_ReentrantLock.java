package mchapter04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class T13_ReadCode_ReentrantLock {
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void method() {
        reentrantLock.lock();
        try {
            System.out.println("临界区");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(T13_ReadCode_ReentrantLock::method, "Thread_Test1").start();
        new Thread(T13_ReadCode_ReentrantLock::method, "Thread_Test2").start();
    }
}
