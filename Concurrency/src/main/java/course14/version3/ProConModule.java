package course14.version3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：生产者消费者模型 - Lock/Condition实现  (注意, 该程序有死锁的风险)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/9
 */
public class ProConModule<T> {
    private final int maxSize;
    private int size = 0;
    private final List<T> queue;
    private final ReentrantLock lock;
    private final Condition notFullCondition;  //队列已满条件
    private final Condition notEmptyCondition; //队列已空条件

    public ProConModule(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new ArrayList<>(maxSize);
        this.lock = new ReentrantLock();
        notFullCondition = lock.newCondition();
        notEmptyCondition = lock.newCondition();
    }

    public void put(T t) {
        lock.lock();
        try {
            while (this.size <= this.maxSize) {
                if (this.size == this.maxSize) {
                    notFullCondition.await();
                } else {
                    queue.add(t);
                    notEmptyCondition.signal();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        T t = null;
        try {
            while (this.size >= 0) {
                if (this.size == 0) {
                    notEmptyCondition.await();
                } else {
                    t = queue.get(0);
                    notFullCondition.signal();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }
}
