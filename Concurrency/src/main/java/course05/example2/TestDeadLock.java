package course05.example2;

import com.nengli51.TestCase;
import com.nengli51.TimeMetrics;
import course05.example1.Account_v2;
import org.junit.Test;

/**
 * 功能说明：测试死锁
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class TestDeadLock {
    @TimeMetrics
    public void testAccount_v2() {
        Account_v2 act1 = new Account_v2();
        Account_v2 act2 = new Account_v2();

        act1.setBalance(10000);
        act2.setBalance(10000);
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
                    act2.transfer(act1, 1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(act1.toString());
        System.out.println(act2.toString());
    }

    @Test
    public void runCase() {
        TestCase.run(TestDeadLock.class);
    }
}
