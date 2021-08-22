package mchapter03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试CountDownLatch
 * 功能上等价于join() 为什么还要设计这个类呢?
 * 答: 在使用上更加灵活, 不一定在子线程Thread[i]执行结束完成之后, 被等待的线程才执行; join做不到在任意位置countDown().
 * 开发人员：@Author MaLi
 */
public class Test3_CountDownLatch {
    public static void main(String[] args) {

        usingCountDownLatch();
    }

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        //设置线程任务
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }

                System.out.println("ThreadName: " + Thread.currentThread().getName() + " --> " + finalI);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();

            });
        }
        // 启动线程
        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 线程等待
        try {
            //等待所有线程执行完毕, 继续执行该线程
            latch.await();//等价于42行代码
            System.out.println("全部线程执行完毕...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
