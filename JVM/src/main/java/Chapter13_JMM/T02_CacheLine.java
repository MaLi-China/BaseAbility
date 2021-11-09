package Chapter13_JMM;

/**
 * 功能说明：测试缓存行
 * CPU读取一次缓存行空间为64byte
 * 开发人员：@author MaLi
 */
public class T02_CacheLine {
    //设计一个64byte的类
    private static class T {
        private volatile long placeholder = 0L;
    }


    //创建一个数组, 占位空间小于64byte(目的: 数组内的两个元素同时落入同一个64byte的缓存行内)
    public static T[] arr = new T[2];
    public static int _100M = 1000_0000;

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < _100M; i++) {
                arr[0].placeholder = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < _100M; i++) {
                arr[1].placeholder = i;
            }
        });

        try {
            long start = System.nanoTime();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            long end = System.nanoTime();
            System.out.println("Time Wasted: " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
