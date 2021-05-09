package course14.version1;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：生产者消费者模型 - synchronized实现
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/9
 */
public class ProConModule<T> {
    //队列实现: 增删快, 没有插入的需求
    private int length = 0;
    private List<T> queue = new ArrayList<>(5);

    public synchronized void consume() {
        T t;
        while (true) {
            if (this.length == 0) { //多余
                try {
                    System.out.println("没有可消费, 消费者暂停.");
                    // 唤醒生产者
                    notifyAll();
                    // 等待被唤醒
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                t = queue.remove(0);
                length--;
                System.out.println("消费者获得: " + t);
                break;
            }
        }
    }

    public synchronized void produce(T t) {
        while (true) {
            if (this.length == 5) {
                try {
                    System.out.println("5个生产完成, 生产者开始休息.");
                    notifyAll(); // 唤醒消费者的同时, 其它的同事生产者也会被叫醒
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                queue.add(t);
                length++;
                try {
                    Thread.sleep(1000);
                    System.out.println("生产中,当前Thread:" + Thread.currentThread().getName() + " -- >产出: " + t);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProConModule<Integer> module = new ProConModule<>();
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                module.consume();
            }
        });
        consumer.start();

        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                module.produce(i);
            }
        });
        Thread producer2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                module.produce(i);
            }
        });
        Thread producer3 = new Thread(() -> {
            for (int i = 20; i < 30; i++) {
                module.produce(i);
            }
        });
        producer1.start();
        producer2.start();
        producer3.start();

        try {
            producer1.join();
            producer2.join();
            producer3.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
