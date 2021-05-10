package course17_ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能说明：针对初始数据量大的场景, 使用懒加载模式
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class LazyCache<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void put(K key, V value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    // 细节: 二次验证缓存中是否存在key; 加写锁
    public V get(K key) {
        readLock.lock();
        V value;
        try {
            value = map.get(key);
        } finally {
            readLock.unlock();
        }
        if (value != null) {
            return value;
        }
        // 懒加载数据, 写集合要加写锁
        writeLock.lock();
        try {
            value = get(key);
            // 二次验证null
            if (value == null) {
                //读取数据库内容, 省略... 用null代替
                value = null; // 读取数据库内容, 保存到缓存中
                put(key, value);
            }
        } finally {
            writeLock.unlock();
        }
        return value;
    }
}
