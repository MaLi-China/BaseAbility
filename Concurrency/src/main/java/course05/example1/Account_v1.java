package course05.example1;

/**
 * 功能说明： 模拟转账 - 多线程并发, 使用Account.class做锁
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class Account_v1 extends Account {
    private long balance;

    public void transfer(Account_v1 target, long amt) {
        this.balance -= amt;
        target.balance += amt;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account_v1{" +
                "balance=" + balance +
                '}';
    }
}
