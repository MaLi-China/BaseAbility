package course05.example1;

/**
 * 功能说明：模拟转账 - 多线程并发, 使用两把锁
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class Account_v2 extends Account {
    private long balance;

    public void transfer(Account_v2 account, long amt) {
        synchronized (this) {
            this.balance -= amt;
            synchronized (account) {
                account.balance += amt;
            }
        }
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account_v2{" +
                "balance=" + balance +
                '}';
    }
}
