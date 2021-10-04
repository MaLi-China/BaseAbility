package mchapter_01;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：验证线程的状态
 * <p>
 * new: 新建
 * runnable: 可运行
 * terminated: 完成
 * <p>
 * blocking: 阻塞
 * waiting: 等待
 * timed-waiting: 定时等待
 * 开发人员：@author MaLi
 */
public class T02_ThreadState {
    @Test
    // 验证线程不同的状态
    public void MT01() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("thread is executing...");
                    TimeUnit.SECONDS.sleep(10);
                    Thread.State state3 = Thread.currentThread().getState();
                    System.out.println("State3: " + state3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.State state5 = Thread.currentThread().getState();
                    System.out.println("State5: " + state5);
                }
            }
        });
        Thread.State state1 = thread.getState();
        System.out.println("State1: " + state1);
        thread.start();
        Thread.State state2 = thread.getState();
        System.out.println("State2: " + state2);
        thread.interrupt();
        Thread.State state4 = thread.getState();
        System.out.println("State4: " + state4);
        System.out.println(thread.isInterrupted());
        state4 = thread.getState();
        System.out.println("State4s: " + state4);
        thread.stop();
        state4 = thread.getState();
        System.out.println("State4ss: " + state4);

    }
}
