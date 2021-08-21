package mchapter02;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：锁优化: 使用细粒度锁
 * 开发人员：@Author MaLi
 */
public class FineCoarseLock {
    /**
     * 缩小锁的粒度
     */
    public void executeProcess() {
        try {
            //模拟业务代码1
            TimeUnit.SECONDS.sleep(1);
            synchronized (FineCoarseLock.class) {
                System.out.println("do something");
            }
            //模拟业务代码2
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
