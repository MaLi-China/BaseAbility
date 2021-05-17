package course23_Future;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/14
 */
public class Demo_ThreadPoolExecutor {
    private ExecutorService pool;

    @Before
    public void init() {
        pool = Executors.newCachedThreadPool();
    }

    @Test
    public void testSubmit2() {
        List<String> result = new ArrayList<>();
        pool.submit(() -> {

            result.add("hello Thread");

        }, result);

        System.out.println(result.size());
    }


    @Test
    public void testSubmit() {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> future = pool.submit(() -> {
            Thread.sleep(1000);
            return "hello thread";
        });
//        future.cancel(true);
        try {
            String msg = future.get();
            System.out.println(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
