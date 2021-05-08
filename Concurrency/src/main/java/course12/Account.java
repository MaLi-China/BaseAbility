package course12;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：测试ReentrantLock的非阻塞方式获取锁
 * -- 该程序有死锁bug
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/8
 */
public class Account {
    private long balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void transfer(Account target, long amt) {
        Random random = new Random();
        while (true) {
//            if (this.lock.tryLock()) {  // 可能造成活锁
            try {
                if (this.lock.tryLock(random.nextInt(10), TimeUnit.NANOSECONDS)) {
                    try {
                        //                    if (target.lock.tryLock()) {    //可能造成活锁
                        if (target.lock.tryLock(random.nextInt(10), TimeUnit.NANOSECONDS)) {
                            try {
                                this.balance -= amt;
                                target.balance += amt;
                                break;
                            } finally {
                                target.lock.unlock();
                            }
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

