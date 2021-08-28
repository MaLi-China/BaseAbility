package mchapter04;

/**
 * 功能说明：使用Synchronized方式, 双线程打印A-Z
 * 开发人员：@Author MaLi
 */
public class T09_PrintAB {
    // 定义一个指针, 用于从0开始依次指向字母字符串的位置
    private volatile static int index = 0;
    // 要打印的内容: 按照顺序的字母
    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // 打印方法: 使用T09_PrintAB.class做互斥锁
    public synchronized static void printChars() {

        while (index < 26) {
            char c = chars.charAt(index);
            System.out.println("Thread_name: " + Thread.currentThread().getName() + " " + c);

            try {
                //关键代码: 每打印依次之后
                // 1, 指针+1, 代表移动一位
                index++;
                // 2, 通知正在等待锁的队列, 准备唤醒
                T09_PrintAB.class.notify();
                if (index >= 24) // 加上这两行代码, 否则程序到达字母边界, 线程不退出, 也就是不停等待
                    break;
                // 3, 当前线程进入等待, 释放锁, 进入等待队列
                T09_PrintAB.class.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 启动线程第一个线程, 任务很简单, 就是调用静态方法printChars()
        new Thread(T09_PrintAB::printChars, "Thread_01").start();

        // 同上, 启动第二个线程
        new Thread(T09_PrintAB::printChars, "Thread_02").start();
    }
}