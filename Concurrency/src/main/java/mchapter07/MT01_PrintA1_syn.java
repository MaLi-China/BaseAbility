package mchapter07;

/**
 * 功能说明：打印A1B2...
 * 版本1: 使用synchronized+wait+notify
 * 版本2: 使用Lock+Condition
 * 版本3: 使用CountDownLatch
 * 版本4: 使用CyclicBarriy
 * <p>
 * 开发人员：@author MaLi
 */
public class MT01_PrintA1_syn {

    private String abc = "abcdefghijklmnopqrstuvwxyz";
    private int index = 0;

    //打印字符方法
    public synchronized void printChar() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " -- " + abc.charAt(index++));
            notify();
            try {
//                TimeUnit.SECONDS.sleep(1);
                if (index == 26) {
                    wait(); //需要释放锁给打印数字的线程, 所以还要阻塞在这里, 等待打印数字完成后, 唤醒该线程退出.
                    break;
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //打印数字方法
    public synchronized void printInt() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " -- " + index);
            notify(); // 最后边界
            try {
                if (index == 26) {
                    break;
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        new Thread(this::printChar, "Thread_PrintChar").start();
        new Thread(this::printInt, "Thread_PrintInteger").start();
    }

    public static void main(String[] args) {
        MT01_PrintA1_syn obj = new MT01_PrintA1_syn();
        obj.print();
    }
}
