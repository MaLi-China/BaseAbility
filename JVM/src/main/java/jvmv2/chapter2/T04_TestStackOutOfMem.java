package jvmv2.chapter2;

import org.junit.Test;

/**
 * 功能说明：测试栈深度
 * 开发人员：@author MaLi
 */
public class T04_TestStackOutOfMem {
    private int count = 0;

    public void doMethod() {
        System.out.println("递归: " + (++count) + " Threadname: " + Thread.currentThread().getName());
        doMethod();
    }

    @Test
    public void testMethod() {
        while (true) {
            new Thread(() -> {
                doMethod();
            }, "Thread-" + count).start();
        }

    }
}
