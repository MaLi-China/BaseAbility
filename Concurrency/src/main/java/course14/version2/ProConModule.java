package course14.version2;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：生产者消费者模型 - synchronized实现(精简)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/9
 */
public class ProConModule<T> {
    private final int maxSize;
    private int size = 0;
    private final List<T> queue;

    public ProConModule(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new ArrayList<>(maxSize);
    }

    public synchronized void put(T t) {
        while (size <= maxSize) {
            if (size == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                queue.add(t);
                notifyAll(); //通知所有等待队列内的线程(生产者, 消费者)开始工作
                break;
            }
        }

    }

    public synchronized T get() {
        T t = null;
        while (size >= 0) {
            if (size == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                t = queue.get(0);
                notifyAll(); //通知所有等待队列内的线程(生产者, 消费者)开始工作
                break;
            }
        }
        return t;
    }
}
