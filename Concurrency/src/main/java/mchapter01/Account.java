package mchapter01;

/**
 * 功能说明：脏读的状态复现
 * 开发人员：@Author MaLi
 */
public class Account {
    private String name;
    private Double account;

    public synchronized void setAccount(String name, Double account) {
        this.name = name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.account = account;
    }

    //如果该方法不加同步, 那么会造成脏读.
    public /*synchronized*/ void getAccount() {
        System.out.println(this);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}';
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> account.setAccount("Mark", 10000.0)).start();
        new Thread(() -> account.getAccount()).start();

    }
}
