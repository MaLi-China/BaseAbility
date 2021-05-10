package course17_ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能说明：读写锁三条基本原则
 * 1, 允许多线程读共享变量;
 * 2, 只允许一个线程写共享变量;
 * 3, 如果有线程写, 那么读线程被禁止
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class Cache<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public V get(K key) {
        readLock.lock();
        V value;
        try {
            value = map.get(key);
        } finally {
            readLock.unlock();
        }
        return value;
    }

    public void add(K key, V value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
}
