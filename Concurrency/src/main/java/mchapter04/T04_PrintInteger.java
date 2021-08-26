package mchapter04;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：两线程交叉打印数字
 * 开发人员：@Author MaLi
 */
public class T04_PrintInteger {
    private int number = 0;
    private final Semaphore lock = new Semaphore(1, true);

    public void printInteger() {
        while (true) {
            try {
                lock.acquire();
                System.out.println("ThreadName: " + Thread.currentThread().getName() + " " + number++);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.release();
            }
        }
    }

    public static void main(String[] args) {
        T04_PrintInteger instance = new T04_PrintInteger();
        new Thread(instance::printInteger, "Thread_01").start();
        try {
            TimeUnit.MILLISECONDS.sleep(20);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(instance::printInteger, "Thread_02-------").start();
    }

}
