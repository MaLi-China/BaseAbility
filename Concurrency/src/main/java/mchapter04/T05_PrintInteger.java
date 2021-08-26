package mchapter04;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：使用Synchronized实现交叉打印数字
 * 开发人员：@Author MaLi
 */
public class T05_PrintInteger {
    private volatile int number = 0;
    private Random random = new Random();

    public synchronized void printInteger() {
        System.out.println("ThreadName: " + Thread.currentThread().getName() + " --> No: " + number++);
        notify();
        try {
            TimeUnit.SECONDS.sleep(1);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T05_PrintInteger instance = new T05_PrintInteger();

        new Thread(() -> {
            while (true) {
                instance.printInteger();
            }
        }, "Thread_01").start();

        new Thread(() -> {
            while (true) {
                instance.printInteger();
            }
        }, "Thread_02").start();
    }
}
