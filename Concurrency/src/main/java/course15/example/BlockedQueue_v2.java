package course15.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：实现阻塞队列 - Lock Condition
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class BlockedQueue_v2<T> {
    private final int size;
    private final ReentrantLock lock;
    private int index;
    private final Condition notFull;
    private final Condition notEmpty;
    private final List<T> queue;

    public BlockedQueue_v2(int size) {
        this.size = size;
        this.lock = new ReentrantLock(true);
        this.index = 0;
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        queue = new ArrayList<>(size);
    }

    //入队
    public void enQueue(T t) {
        lock.lock();
        try {
            while (index <= this.size) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (index == this.size) {
                    try {
                        System.out.println("线程名称: " + Thread.currentThread().getName() + " --> 队列满, 开始休息!");
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.queue.add(t);
                    System.out.println("线程名称: " + Thread.currentThread().getName() + " --> 入队" + t + "准备叫醒出队线程...");
                    this.index++;
                    notEmpty.signal();
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    //出队
    public T deQueue() {
        lock.lock();
        T t = null;
        while (index >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index == 0) {
                try {
                    System.out.println("线程名称: " + Thread.currentThread().getName() + " --> 队列kong, 开始休息!");
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                t = this.queue.remove(0);
                System.out.println("线程名称: " + Thread.currentThread().getName() + " --> 出队" + t + "准备叫醒入队线程...");
                this.index--;
                notFull.signal();
                break;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        BlockedQueue_v2<String> queue = new BlockedQueue_v2<String>(3);
        AtomicInteger i = new AtomicInteger();

        Thread en1 = new Thread(() -> {
            while (true) {
                queue.enQueue("No:" + i.incrementAndGet());
            }
        });
        en1.start();
        Thread en2 = new Thread(() -> {
            while (true) {
                queue.enQueue("No:" + i.incrementAndGet());
            }
        });
        en2.start();
        Thread en3 = new Thread(() -> {
            while (true) {
                queue.enQueue("No:" + i.incrementAndGet());
            }
        });
        en3.start();


        Thread de1 = new Thread(() -> {
            while (true) {
                queue.deQueue();
            }
        });
        de1.start();
        Thread de2 = new Thread(() -> {
            while (true) {
                queue.deQueue();
            }
        });
        de2.start();
        Thread de3 = new Thread(() -> {
            while (true) {
                queue.deQueue();
            }
        });
        de3.start();

        try {
            en1.join();
            en2.join();
            en3.join();
            de1.join();
            de2.join();
            de3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
