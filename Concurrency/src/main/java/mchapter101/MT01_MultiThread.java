package mchapter101;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 功能说明：多线程计算1亿个数的和
 * 开发人员：@author MaLi
 */
public class MT01_MultiThread {
    private static double[] nums = new double[1_0000_0000];
    private static Random random = new Random();
    private static DecimalFormat format = new DecimalFormat("0.00");

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextDouble();
        }
    }

    // 单线程计算
    public static void m1() {
        long start = System.currentTimeMillis();
        double result = 0;
        for (double num : nums) {
            result += num;
        }
        /*for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }*/
        long end = System.currentTimeMillis();
        System.out.println("Result: " + format.format(result) + " Time wasted: " + (end - start));
    }

    //多线程计算
    public static void m2() {
        long start = System.currentTimeMillis();
        //线程数
        int threadNums = 1000;
        //每个线程的计算范围
        int segmentCount = nums.length / threadNums;
        //每个线程的计算结果
        double[] results = new double[threadNums];
        //线程数组
        Thread[] threads = new Thread[threadNums];
        //线程锁
//        CountDownLatch latch = new CountDownLatch(threadNums);

        for (int i = 0; i < threadNums; i++) {
            int m = i;
            threads[i] = new Thread(() -> {
                for (int j = m * segmentCount; j < (m + 1) * segmentCount && j < nums.length; j++) {
                    results[m] += nums[j];
                }
            });
        }
        for (int i = 0; i < threadNums; i++) {
            threads[i].start();

        }
        for (int i = 0; i < threadNums; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double result = 0;
        for (int i = 0; i < threadNums; i++) {
            result += results[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("Result: " + format.format(result) + " Time wasted: " + (end - start));
    }

    public static void main(String[] args) {
        m1();
        m2();
    }

    @Test
    //获取CPU核数
    public void M01_obtainCPUAmount() {
        int nums = Runtime.getRuntime().availableProcessors();
        System.out.println(nums);
    }

}
