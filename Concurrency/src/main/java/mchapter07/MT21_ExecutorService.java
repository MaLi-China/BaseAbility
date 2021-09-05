package mchapter07;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MT21_ExecutorService {
    @Test
    public void test_M01() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Task executed...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "xxx");
        try {
            String s = future.get();
            System.out.println("s: " + s);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("s: " + s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
