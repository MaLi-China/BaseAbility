package course18_StamptedLock.example;

import com.nengli51.TestCase;
import com.nengli51.TimeMetrics;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：测试互斥锁
 * 比较读写锁与乐观读锁的性能差异
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class Cache_WithLock<K, V> {
    private final HashMap<K, V> map = new HashMap<>();
    private final Random random = new Random();
    private final Lock lock = new ReentrantLock();

    //Read Cache
    public V getValue(K key) {
        lock.lock();
        V value;
        try {
            value = map.get(key);
        } finally {
            lock.unlock();
        }
        return value;
    }

    //Write Cache
    public void writeValue(K key, V value) {
        lock.lock();
        try {
            map.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    //测试
    // 缓存10000个数据, 读写

    @TimeMetrics
    public void testCache() {
        Cache_WithLock<Integer, Integer> cache = new Cache_WithLock<Integer, Integer>();

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

    private void caseMethod1(Cache_WithLock<Integer, Integer> cache) {
        for (int i = 0; i < 10000000; i++) {
            Integer value = cache.getValue(i);
            if (value == null) {
                lock.lock();
                try {
                    Integer v = random.nextInt(10000);
                    cache.writeValue(i, v);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void testCase() {
        TestCase.run(Cache_WithLock.class);
    }
}
