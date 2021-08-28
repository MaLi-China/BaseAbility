package mchapter04;

/**
 * 功能说明：打印字母和数字
 * 1A2B3C4D...25Y26Z
 * 开发人员：@Author MaLi
 */
public class T10_PrintAB {
    private volatile int index = 0;
    private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public synchronized void printChars() {
        // 按照指针从0到25, 打印chars中的每一个字母
        while (index <= 25) {
            //1, 打印字母
            System.out.println("ThreadNo:" + Thread.currentThread().getName() + "-->" + chars.charAt(index++));
            // 2, 打印完成通知另一个线程开始打印数字
            notify();
            try {
                // 3, 释放锁
                wait();
                // 4, 如果到了chars的边界位置, 跳出当前循环, 线程任务结束
                if (index == 26) { //由于上面有了一次index++, 所以让index走到边界的时候, 直接退出循环就可以了, 没有必要wait()释放锁
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printInteger() {
        //
        while (true) {
            // 1,打印数字
            System.out.println("ThreadNo:" + Thread.currentThread().getName() + "-->" + (index + 1));
            //2, 打印完成, 通知另一个线程
            notify();
            try {
                // 3, 释放锁, 等待被唤醒, 此时另外一个线程可以得到锁
                wait();
                //4, 当边界到达26的时候, 跳出当前循环, 线程任务结束
                if (index == 26) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        T10_PrintAB instance = new T10_PrintAB();
        new Thread(instance::printInteger, "Thread_02").start();
        new Thread(instance::printChars, "Thread_01").start();
    }
}
