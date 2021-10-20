package C01_Thread;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：创建线程的方式
 * 开发人员：@author MaLi
 */
public class T01_GenerateThread {

    //Method1
    public static class Thread_extendThread extends Thread {
        @Override
        public void run() {
            System.out.println("Generate Thread Method 1 \t ThreadName: " + Thread.currentThread().getName() + " is running...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Generate Thread Method 1 \t ThreadName: " + Thread.currentThread().getName() + " has been ended...");
        }
    }

    //Method2
    public static class Thread_implRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Generate Thread Method 2 \t ThreadName: " + Thread.currentThread().getName() + " is running...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Generate Thread Method 2 \t ThreadName: " + Thread.currentThread().getName() + " has been ended...");
        }
    }

    //Method3: ThreadPool(Executors or CustomExecutor)

    //Method4: Anonymous Inner Class

    //Method5: Lambda
}
