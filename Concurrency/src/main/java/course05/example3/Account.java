package course05.example3;

/**
 * 功能说明：线程安全的账户 - 转账操作
 * (1) 线程安全
 * (2) 规避死锁: 破坏占有且等待(一次申请获取到全部锁)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/7
 */
public class Account {
    public long balance;

    /**
     * (1)双synchronized保证线程安全: 保证同一时刻, 只能有一个线程操作两个线程的任意一个;
     * (2)使用Allocator: 避免死锁, 避免同一时刻, this与to两个账户都进行转账业务
     *
     * @param to  转出账户
     * @param amt 转出金额
     */
    public void transfer(Account to, long amt) {
        while (!Allocator.apply(this, to)) {
            break;
        }
        synchronized (this) {
            synchronized (to) {
                try {
                    this.balance -= amt;
                    to.balance += amt;
                } finally {
                    Allocator.free(this, to);
                }
            }
        }
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
