package course15.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能说明：实现阻塞队列 - synchronized实现
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class BlockedQueue<T> {
    private final List<T> queue;
    private int index;
    private final int size;

    public BlockedQueue(int size) {
        this.queue = new ArrayList<>(size);
        this.index = 0;//初始化为0代表为空
        this.size = size;
    }

    //入队
    public synchronized void enQueue(T t) {
        //while循环用于当前线程被唤醒后, 再次检测条件是否满足
        while (true) {
            if (index == this.size) {
                try {
                    System.out.println("队列空间已满, 暂停入队");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.queue.add(t);
                this.index++;
                notifyAll();//告诉其它线程可以消费了
                break;
            }
        }
    }


    //出队
    public synchronized T deQueue() {
        T t;
        while (true) {
            if (index == 0) {
                try {
                    System.out.println("队列空, 暂停出队...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                t = this.queue.remove(0);
                this.index--;
                notifyAll();// 告诉其它线程可以生产了
                break;
            }
        }
        return t;
    }


    public static void main(String[] args) {
        BlockedQueue<String> queue = new BlockedQueue<String>(3);
        AtomicInteger index = new AtomicInteger();
        Thread enQueue = new Thread(() -> {
            while (true) {
                queue.enQueue("入队No: " + (index.incrementAndGet()));
                System.out.println("入队No: " + index.get());
            }
        });
        enQueue.start();
        Thread deQueue = new Thread(() -> {
            while (true) {
                String msg = queue.deQueue();
                System.out.println(Thread.currentThread().getName() + " 出队: " + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        deQueue.start();
        Thread deQueue2 = new Thread(() -> {
            while (true) {
                String msg = queue.deQueue();
                System.out.println(Thread.currentThread().getName() + " 出队: " + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        deQueue2.start();
        try {
            enQueue.join();
            deQueue.join();
            deQueue2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
