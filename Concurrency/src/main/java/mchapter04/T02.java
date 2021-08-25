package mchapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试面试题
 * 开发人员：@Author MaLi
 */
public class T02 {
    private List<Object> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public void add(Object obj) {
        list.add(obj);
    }

    public static void main(String[] args) {

        T02 instance = new T02();
        Thread T1 = new Thread(() -> {
            //任务: 放入10个元素
            for (int i = 0; i < 10; i++) {
                instance.add(new Object());
                System.out.println("Added No: " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread T2 = new Thread(() -> {
            while (true) {
                if (instance.size() == 5) {
                    System.out.println(Thread.currentThread().getName() + " checked element added 5");
                }
            }
        }, "Thread-2");

        T1.start();
        T2.start();
    }
}
