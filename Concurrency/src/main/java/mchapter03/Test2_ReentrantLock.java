package mchapter03;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Test2_ReentrantLock {
    public static void main(String[] args) {
        Son son = new Son();
        new Thread(son::method2, "Thread_Son").start();
    }
}

class Father {
    public synchronized void method1() {
        System.out.println("method1 enter");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        System.out.println("ThreadName:" + name + " --> " + "method1");
    }
}

class Son extends Father {

    @Override
    public synchronized void method1() {
        System.out.println("Son method1");
        System.out.println("CurrentThread(Son): " + Thread.currentThread().getName());
        super.method1();
    }

    public synchronized void method2() {
        System.out.println("method2 enter");
        this.method1();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        System.out.println("ThreadName:" + name + " --> " + "method2");

    }

    public static void main(String[] args) {
        Son son = new Son();
        son.method1();
    }
}

