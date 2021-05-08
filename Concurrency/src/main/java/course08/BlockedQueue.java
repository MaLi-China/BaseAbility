package course08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：模拟阻塞队列
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/8
 */
public class BlockedQueue<T> {
    private int length;
    private List<T> queue = new ArrayList<>();
    private ReentrantLock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    //入队
    public void enq(T t) {
        lock.lock();
        try {
            //条件不满足
            while (length >= 3) {
                try {
//                    wait();
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //条件满足
            queue.add(t);
            length++;
//            notifyAll();
            //通知条件满足, 可以出队了;
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //出队
    public T deq() {
        lock.lock();
        T t = null;
        try {
            //条件不满足
            while (length <= 0) {
                try {
//                    wait();
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = queue.remove(0);
            length--;
//            notifyAll();
            //通知条件满足, 可以入队了
            full.signalAll();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {

        BlockedQueue<Integer> queue = new BlockedQueue<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.enq(i);

                System.out.println("入队" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer element = queue.deq();
                System.out.println("出队" + element);
            }
        });
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
