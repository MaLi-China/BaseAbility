package mchapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：使用LockCondition实现生产者与消费者模型
 * 开发人员：@Author MaLi
 */
public class T08_ProducerConsumer<T> {
    private List<T> container = new ArrayList<>();
    private int maxSize = 10;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFullCondition = lock.newCondition();
    private final Condition notEmptyCondition = lock.newCondition();


    public void put(T t) {
        try {
            lock.lock();
            //循环判断
            while (container.size() == maxSize) {

                try {
                    // 释放锁
                    notFullCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //确定容器中不满, 则添加元素, 否则在while中等待
            container.add(t);
            //通知其它角色开始工作
            notEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized T get() {
        T t;
        try {
            lock.lock();
            while (container.size() == 0) {
                notFullCondition.signalAll();
                try {
                    notEmptyCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = container.remove(0);
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        T08_ProducerConsumer<Integer> instance = new T08_ProducerConsumer<>();
        AtomicInteger number = new AtomicInteger(0);
        //
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    int result = number.incrementAndGet();
                    instance.put(result);
                    System.out.println("Thread_name:" + Thread.currentThread().getName() + " Result Added: " + result);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }, "Producer_" + i).start();
        }

        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                while (true) {
                    Integer result = instance.get();
                    System.out.println("Thread_name:" + Thread.currentThread().getName() + " Result Getted: " + result);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Consumer_" + i).start();
        }
    }
}
