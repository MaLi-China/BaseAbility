package course20_Collections.example;

import org.junit.Test;

/**
 * 功能说明：竟态条件测试
 * 数据竞争: 不止一个线程写变量
 * 竟态条件: 多线程, 顺序不同的读写数据, 得到的结果不确定
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class RaceCondition {
    //组合两个竟态
    private int num = 0;

    public synchronized int get() {
        return num;
    }

    public synchronized void set(int num) {
        this.num = num;
    }

    public synchronized void add10K() {
        for (int i = 0; i < 10000; i++) {
            set(get() + 1);
        }
        System.out.println(Thread.currentThread().getName() + " -->num: " + num);
    }

    @Test
    public void testMethod() {
        Thread t1 = new Thread(this::add10K);
        Thread t2 = new Thread(this::add10K);
        Thread t3 = new Thread(this::add10K);

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println(this.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
