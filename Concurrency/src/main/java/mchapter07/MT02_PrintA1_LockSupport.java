package mchapter07;

import java.util.concurrent.locks.LockSupport;

/**
 * 功能说明：使用LockSupport打印A1B2C3...
 * 开发人员：@author MaLi
 */
public class MT02_PrintA1_LockSupport {
    private static String abc = "abcdefghijklmnopqrstuvwxyz";
    private static int index = 0;
    private static Thread t1 = null, t2 = null;

    private static void print() {
        t1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " --> " + abc.charAt(index++));
                LockSupport.unpark(t2);
                if (index == 26) {
                    break;
                }
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " --> " + index);
                if (index == 26) {
                    break;
                }
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        print();
    }
}
