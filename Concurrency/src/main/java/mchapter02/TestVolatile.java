package mchapter02;


import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：线程安全的累加
 * 开发人员：@Author MaLi
 */
public class TestVolatile {
    /*volatile*/ int count;

    /*synchronized*/ void method() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(testVolatile::method, "Thread-" + i);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //输出count的值
        System.out.println(testVolatile.count);
    }
}
