package course18_StamptedLock.example;

import com.nengli51.TestCase;
import com.nengli51.TimeMetrics;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.StampedLock;

/**
 * 功能说明：测试读写锁: 乐观读
 * 比较其它锁与乐观读锁的性能差异
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class Cache_WithStampedLock_OptimisticRead<K, V> {
    public final HashMap<K, V> map = new HashMap<>();
    public final StampedLock stamptedLock = new StampedLock();
    private final Random random = new Random();

    //Read Cache
    public V getValue(K key) {
        long stamp = stamptedLock.tryOptimisticRead();
        V value;
        try {
            value = map.get(key);
            if (!stamptedLock.validate(stamp)) {
                //升级悲观读锁
                stamp = stamptedLock.readLock();
                //重新获取值
                value = map.get(key);
            }
        } finally {
            stamptedLock.unlockRead(stamp);
        }
        return value;
    }

    //Write Cache
    public void writeValue(K key, V value) {
        long stamp = stamptedLock.writeLock();
        try {
            map.put(key, value);
        } finally {
            stamptedLock.unlockWrite(stamp);
        }
    }

    //测试
    // 缓存10000个数据, 读写

    @TimeMetrics
    public void testCache() {
        Cache_WithStampedLock_OptimisticRead<Integer, Integer> cache = new Cache_WithStampedLock_OptimisticRead<Integer, Integer>();

        Thread thread1 = new Thread(() -> caseMethod1(cache));
        thread1.start();
        Thread thread2 = new Thread(() -> caseMethod1(cache));
        thread2.start();
        Thread thread3 = new Thread(() -> caseMethod1(cache));
        thread3.start();
        Thread thread4 = new Thread(() -> caseMethod1(cache));
        thread4.start();
        Thread thread5 = new Thread(() -> caseMethod1(cache));
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void caseMethod1(Cache_WithStampedLock_OptimisticRead<Integer, Integer> cache) {
        for (int i = 0; i < 10000000; i++) {
            Integer value = cache.getValue(i);
            if (value == null) {
                long stamp = stamptedLock.writeLock();
                try {
                    Integer v = random.nextInt(10000);
                    cache.writeValue(i, v);
                } finally {
                    stamptedLock.unlockWrite(stamp);
                }
            }
        }
    }

    @Test
    public void testCase() {
        TestCase.run(Cache_WithStampedLock_OptimisticRead.class);
    }
}
