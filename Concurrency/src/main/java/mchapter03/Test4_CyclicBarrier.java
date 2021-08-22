package mchapter03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试使用CylicBarrier
 * 开发人员：@Author MaLi
 */
public class Test4_CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("被重创, 开启新生命...");
            }
        });

        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println("发射一次: " + finalI);

                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
