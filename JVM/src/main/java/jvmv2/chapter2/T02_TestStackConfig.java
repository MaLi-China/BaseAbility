package jvmv2.chapter2;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T02_TestStackConfig {
    private int count = 0;

    public void recursion() {
        System.out.println("------------------------>" + (++count));//6040
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recursion();
    }

    @Test
    public void testStackParms() {
        Runtime runtime = Runtime.getRuntime();
        int availableProcessors = runtime.availableProcessors();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
    }


    @Test
    public void testRecursion() {
        recursion();
    }
}
