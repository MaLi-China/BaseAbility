package C01_Thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：线程的状态
 * new-->runnable-->terminated
 * waiting/timedWating
 * blocked
 * <p>
 * 开发人员：@author MaLi
 */
public class T02_ThreadState {
    /**
     * 测试线程状态:NEW, RUNNABLE, TERMINATED, TIMED_WAITING
     */
    @Test
    public void test1_threadState() {
        Thread t = new Thread(() -> {
            System.out.println("#3 - Before Sleep State: " + Thread.currentThread().getState());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Thread Task ending...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread1");

        System.out.println("#1 - Before Start State: " + t.getState());
        t.start();

        System.out.println("#2 - After Start State: " + t.getState());
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("#4 - After Sleep~ State: " + t.getState());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("#5 - After End~ State: " + t.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试线程状态: BLOKED
     */
    @Test
    public void test2_threadState() {
        Thread t1 = new Thread(() -> blockingMethod(), "t1");

        Thread t2 = new Thread(() -> blockingMethod(), "t2");

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        System.out.println("T1 State: " + t1.getState());
        System.out.println("T2 State: " + t2.getState());
    }

    public void blockingMethod() {
        synchronized (T02_ThreadState.class) {
            System.out.println(Thread.currentThread().getName() + " is running in critical area");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " ending...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
