package mchapter04;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能说明：面试题1
 * <p>
 * 开发人员：@Author MaLi
 */
public class Container {
    private static int size;
    private static List<Object> container;

    public static void add(Object element) {
        container.add(element);
        size++;
    }

    public static int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Random random = new Random();


        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                //不断放元素到容器
                container.add(random.nextInt());
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread1");
        Thread t2 = new Thread(() -> {
            //监控元素的个数, 容器到达5时给出提示
        }, "Thread2");

    }
}
