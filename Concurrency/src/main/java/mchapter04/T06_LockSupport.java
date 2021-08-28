package mchapter04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 功能说明：测试使用LockSupport交叉打印数字
 * 开发人员：@Author MaLi
 */
public class T06_LockSupport {
    private int number = 0;

    public void printNumber() {
        System.out.println("ThreadName: " + Thread.currentThread().getName() + " ---No.: " + number++);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T06_LockSupport instance = new T06_LockSupport();
        Thread t1;
        Thread t2;
        t1 = new Thread(() -> {
            while (true) {
                if (instance.number % 2 == 0) {
                    LockSupport.park();
                }
                instance.printNumber();
            }
        }, "Thread_01");

        t2 = new Thread(() -> {
            while (true) {
                if (instance.number % 2 == 1) {
                    LockSupport.park();
                }
                instance.printNumber();
            }
        }, "Thread_02");

        t1.start();

        t2.start();
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (instance.number % 2 == 0) {
                LockSupport.unpark(t1);
            } else {
                LockSupport.unpark(t2);
            }
        }
    }
}
