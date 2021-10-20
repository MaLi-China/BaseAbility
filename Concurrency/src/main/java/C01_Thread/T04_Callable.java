package C01_Thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T04_Callable {
    @Test
    public void test_MCallable() {
        //创建可以获取返回值的任务
        FutureTask<String> futureTask = new FutureTask<>(new MCallable());

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Callable's method is running...");
            return "First";
        }
    }
}
