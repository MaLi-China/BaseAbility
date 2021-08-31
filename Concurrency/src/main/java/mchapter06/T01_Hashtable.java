package mchapter06;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能说明：对各种Map做性能测试
 * 开发人员：@Author MaLi
 */
public class T01_Hashtable {
    //准备2个数组: keys, values作为测试用例
    private static UUID[] keys = new UUID[Constant.LENGTH];
    private static UUID[] values = new UUID[Constant.LENGTH];
    //待测试的数据结构
    private static Hashtable<UUID, UUID> hashtable = new Hashtable<>();
    private static HashMap<UUID, UUID> hashmap = new HashMap<>();
    private static Map<UUID, UUID> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    private static Map<UUID, UUID> concurrentHashMap = new ConcurrentHashMap<>();

    static {
        // 初始化创建用例数据
        for (int i = 0; i < Constant.LENGTH; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    /**
     * 创建写线程, 开启线程, 完成测试用例
     *
     * @param map 待测试的数据结构Map
     */
    public static void testWriteMap(Map<UUID, UUID> map) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[Constant.THREAD_COUNT];
        for (int i = 0; i < Constant.THREAD_COUNT; i++) {
            threads[i] = new TestWriteMap(i * (Constant.LENGTH / Constant.THREAD_COUNT), map);
        }
        for (int i = 0; i < Constant.THREAD_COUNT; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long wasted = System.currentTimeMillis() - start;
        System.out.println("Time wasted: " + wasted + " --> Size: " + map.size());
    }

    /**
     * 创建读线程, 开启线程, 完成测试用例
     *
     * @param map 待测试的数据结构Map
     */
    public static void testReadMap(Map<UUID, UUID> map) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[Constant.THREAD_COUNT];
        for (int i = 0; i < Constant.THREAD_COUNT; i++) {
            threads[i] = new TestReadMap(map);
        }

        for (int i = 0; i < Constant.THREAD_COUNT; i++) {
            try {
                threads[i].start();
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long wasted = System.currentTimeMillis() - start;
        System.out.println("Time wasted: " + wasted + " --> Size: " + map.size());
    }


    public static void main(String[] args) {
        System.out.println("---------------------ConcurrentHashMap---------------------");
        testWriteMap(concurrentHashMap);
        System.out.println("---------------------Hashtable---------------------");
        testWriteMap(hashtable);
        System.out.println("---------------------SynchronizedHashMap---------------------");
        testWriteMap(synchronizedMap);
/*        System.out.println("---------------------HashMap---------------------");
        testWriteMap(hashmap);*/

        System.out.println("====================================================================");

        System.out.println("---------------------ConcurrentHashMap---------------------");
        testReadMap(concurrentHashMap);
        System.out.println("---------------------Hashtable---------------------");
        testReadMap(hashtable);
        System.out.println("---------------------SynchronizedHashMap---------------------");
        testReadMap(synchronizedMap);
/*        System.out.println("---------------------HashMap---------------------");
        testReadMap(hashmap);*/
    }

    /**
     * 创建测试写Map的线程
     */
    static class TestWriteMap extends Thread {
        private int start;
        private int gap = Constant.LENGTH / Constant.THREAD_COUNT;
        private Map<UUID, UUID> map;

        public TestWriteMap(int start, Map<UUID, UUID> map) {
            this.start = start;
            this.map = map;
        }

        @Override
        public void run() {
            for (int i = start; i < start + gap; i++) {
                map.put(keys[i], values[i]);
            }
        }
    }

    //测试读Map的线程
    static class TestReadMap extends Thread {
        private Random random = new Random();
        private Map<UUID, UUID> map;

        public TestReadMap(Map<UUID, UUID> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                map.get(keys[random.nextInt(Constant.LENGTH)]);
            }
        }
    }
}
