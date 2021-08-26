package course14.example;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：测试使用lock的使用(作用, 破坏不可抢占)
 * 造成死锁的几种方式:
 * (1)占有锁并等待其它锁;
 * (2)占有的锁不可被其它线程抢占;
 * (3)循环占有
 * Java基于monitor技术已经解决(1)和(3),下面JDK并发包解决了(2)
 * 1, 获取不到锁, 马上返回;
 * 2, 时间范围内获取不到返回
 * 3, 阻塞可以被中断
 * <p>
 * 一把锁的情况下, 没有死锁问题, 是否有必要使用JDK并发包?
 * 需求: 不阻塞的方式获取锁
 * <p>
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/9
 */
public class Account {
    private final ReentrantLock rtl = new ReentrantLock();
    private long balance = 0;
    private int i;

    /**
     * 虽然没有死锁问题, 但是如果使用tryLock()的话, 会存在活锁问题, 因为两个线程都在谦让.
     * 解决问题的办法: 加随机数
     */
    public void transfer(Account target, long amt) {
        Random random = new Random();

        while (true) {
            try {
                if (this.rtl.tryLock(random.nextInt(1000), TimeUnit.MILLISECONDS)) {//如果成功获取到锁, 返回true   改行代码, 可能两个线程都获取到了
                    try {
                        if (target.rtl.tryLock(random.nextInt(1000), TimeUnit.MILLISECONDS)) {
                            try {
                                this.balance -= amt;
                                target.balance += amt;
                            } finally {
                                target.rtl.unlock();
                            }
                        }
                    } finally {
                        this.rtl.unlock();
                    }
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
