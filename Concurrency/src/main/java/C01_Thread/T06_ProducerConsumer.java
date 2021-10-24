package C01_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：使用wait/notify-实现生产者消费者模型
 * 可以进入等待状态的情况: 1, join; 2, wait; 3, sleep;
 * 同步方法进入的状态: blocked
 * 开发人员：@author MaLi
 */
public class T06_ProducerConsumer {
    private static final byte[] lock = {1};
    private static int size = 0;
    private static List<Integer> container = new ArrayList<>(10);

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            int e = 0;
            while (true) {
                synchronized (lock) {
                    lock.notify();
                    if (size >= 3 && size <= 10) {
                        System.out.println("Producer: sleep for a moment");
                        try {
                            lock.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        sleep1s();//延时1S
                        container.add(++e);
                        ++size;
                        System.out.println("Producer: already input " + e);
                    }

                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    lock.notify();
                    if (size == 0) {
                        try {
                            System.out.println("Consumer: sleep for a moment");
                            lock.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        sleep1s();//延时1S
                        Integer e = container.remove(0);
                        --size;
                        System.out.println("Consumer: already output " + e);
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep1s() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
