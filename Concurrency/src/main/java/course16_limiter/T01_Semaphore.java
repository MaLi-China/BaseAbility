package course16_limiter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试使用Semaphore实现累加器
 * 原理:
 * 1, Semaphore持有的值<0 -->当前线程阻塞;
 * 2, Semaphore持有的值>=0 --> 当前线程运行
 * 开发人员：@Author MaLi
 */
public class T01_Semaphore {

    private static int count = 0;
    private final static Semaphore lock = new Semaphore(1, true);

    public static void addOne() {
        int index = 5;
        while (index-- > 0) {
            try {
                //减1 >=0当前线程可以执行
                //哪个线程先获取到lock
                lock.acquire();
                count++;
                String name = Thread.currentThread().getName();
                System.out.println("Thread is running: " + name + "; the count = " + count);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //加1
                lock.release();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(T01_Semaphore::addOne, "Thread_01").start();
        new Thread(T01_Semaphore::addOne, "Thread_02").start();
    }
}
