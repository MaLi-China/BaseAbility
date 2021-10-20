package C01_Thread;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试被Join之后, 线程的状态: waiting
 * 开发人员：@author MaLi
 */
public class T03_Join {
    public static void main(String[] args) {
        Thread thread_Outter = new Thread(() -> {
            // 创建一个内部线程
            Thread thread_Inner = new Thread(() -> {
                try {

                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            //启动线程
            thread_Inner.start();
            try {
                // 暂停宿主线程, 让当前线程执行结束
                thread_Inner.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread_Outter.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("State Before Join: " + thread_Outter.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State After Join: " + thread_Outter.getState());
    }
}
