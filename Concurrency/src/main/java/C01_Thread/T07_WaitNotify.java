package C01_Thread;

/**
 * 功能说明：线程同步(同一个锁的wait/notify)
 * 开发人员：@author MaLi
 */
public class T07_WaitNotify {
    private static final byte[] lock = {1};

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 is running");
                try {
                    lock.notify();
                    lock.wait();
                    System.out.println("t1 run second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 is running");
                try {
                    lock.notify();
                    lock.wait();
                    System.out.println("t2 run second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
