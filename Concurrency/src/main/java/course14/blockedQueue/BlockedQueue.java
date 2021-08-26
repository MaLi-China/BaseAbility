package course14.blockedQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：实现一个阻塞队列
 * 开发人员：@Author MaLi
 */
public class BlockedQueue {
    //锁: 用于互斥
    final private ReentrantLock lock = new ReentrantLock();
    // condition: 用于同步, 通信
    final private Condition notFullCondition = lock.newCondition();
    final private Condition notEmptyCondition = lock.newCondition();
    private List<Object> container = new ArrayList<>(5);

    //入队
    public void push(Object object) {
        lock.lock();
        try {
            while (this.container.size() == 5) {
                notFullCondition.await();
            }
            container.add(object);
            notEmptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //出队
    public Object pop() {
        lock.lock();
        Object result = null;
        try {
            while (this.container.size() == 0) {
                notFullCondition.await();
            }
            result = container.remove(0);
            notFullCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

}

