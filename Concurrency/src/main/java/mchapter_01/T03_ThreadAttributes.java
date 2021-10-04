package mchapter_01;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * 1, 线程的属性
 * 2, 线程的状态: join之后, 等待线程退出后, 再去查看它的状态: TERMINATED
 * 开发人员：@author MaLi
 */
public class T03_ThreadAttributes {
    @Test
    public void MT01() {
        Thread t1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            String threadName = thread.getName();
            ThreadGroup threadGroup = thread.getThreadGroup();
            long id = thread.getId();
            int priority = thread.getPriority();
            System.out.println("ThreadName: " + threadName + "\r\nThreadGroup: " + threadGroup + "\r\nThreadID: " + id + "\r\nThreadPriority: " + priority);
            System.out.println("ThreadState: " + thread.getState());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("T1.state: " + t1.getState());
        t1.setDaemon(false);//This method must be invoked before the thread is started.
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T1 state: " + t1.getState());
    }
}
