package course05.example1;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class Account_v3 extends Account {
    private long balance;

    public void transfer(Account_v3 account, long amt) {
        synchronized (Account_v3.class) {
            this.balance -= amt;
            account.balance += amt;
        }
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account_v3{" +
                "balance=" + balance +
                '}';
    }
}
