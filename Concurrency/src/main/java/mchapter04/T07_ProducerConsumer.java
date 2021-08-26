package mchapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能说明：使用synchronized实现生产者消费者模型
 * 开发人员：@Author MaLi
 */
public class T07_ProducerConsumer<T> {
    private List<T> container = new ArrayList<>();
    private int maxSize = 10;

    public synchronized void put(T t) {
        //循环判断
        while (container.size() == maxSize) {
            //通知其它角色开始工作
            notifyAll();
            try {
                // 释放锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //确定容器中不满, 则添加元素, 否则在while中等待
        container.add(t);
    }

    public synchronized T get() {
        while (container.size() == 0) {
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return container.remove(0);
    }

    public static void main(String[] args) {
        T07_ProducerConsumer<Integer> instance = new T07_ProducerConsumer<>();
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
