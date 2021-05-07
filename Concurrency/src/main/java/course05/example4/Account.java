package course05.example4;

/**
 * 功能说明：线程安全, 且避免死锁的Account类 - 采用破坏循环等待的方式
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/7
 */
public class Account {
    private int accountId;
    private long balance;

    /**
     * (1)双synchronized保证线程安全: 保证同一时刻, 只能有一个线程操作两个线程的任意一个;
     * (2)使用Allocator: 避免死锁, 避免同一时刻, this与to两个账户都进行转账业务
     *
     * @param to  转出账户
     * @param amt 转出金额
     */
    public void transfer(Account to, long amt) {
        Account firstLock = this;
        Account secondLock = to;
        if (this.accountId < to.accountId) {
            firstLock = to;
            secondLock = this;
        }
        // 原理: 给两把锁排个序
        synchronized (firstLock) {
            synchronized (secondLock) {
                this.balance -= amt;
                to.balance += amt;
            }
        }
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
