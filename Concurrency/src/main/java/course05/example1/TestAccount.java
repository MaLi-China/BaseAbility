package course05.example1;

import com.nengli51.TestCase;
import com.nengli51.TimeMetrics;
import org.junit.Test;

/**
 * 功能说明：测试不同粒度锁的性能问题
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class TestAccount {
    //    @TimeMetrics
    public void testAccount_v1() {
        Account_v1 act1 = new Account_v1();
        Account_v1 act2 = new Account_v1();
        Account_v1 act3 = new Account_v1();

        doService(act1, act2, act3);
    }

    @TimeMetrics
    public void testAccount_v2() {
        Account_v2 act1 = new Account_v2();
        Account_v2 act2 = new Account_v2();
        Account_v2 act3 = new Account_v2();
        act1.setBalance(10000);
        act2.setBalance(10000);
        act3.setBalance(10000);
        doService(act1, act2, act3);
    }

    @TimeMetrics
    public void testAccount_v3() {
        Account_v3 act1 = new Account_v3();
        Account_v3 act2 = new Account_v3();
        Account_v3 act3 = new Account_v3();
        act1.setBalance(10000);
        act2.setBalance(10000);
        act3.setBalance(10000);
        doService(act1, act2, act3);
    }

    private void doService(Account act1, Account act2, Account act3) {
        act1.setBalance(10000);
        act2.setBalance(10000);
        act3.setBalance(10000);
        try {
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    act1.transfer(act2, 1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    act2.transfer(act3, 1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread t3 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    act3.transfer(act1, 1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(act1.toString());
        System.out.println(act2.toString());
        System.out.println(act3.toString());
    }

    @Test
    public void runCase() {
        TestCase.run(TestAccount.class);
    }
}
