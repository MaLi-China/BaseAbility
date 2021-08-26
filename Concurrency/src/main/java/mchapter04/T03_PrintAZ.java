package mchapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 功能说明：两个线程顺序交叉打印字母
 * 方式1:使用Semaphore实现
 * 开发人员：@Author MaLi
 */
public class T03_PrintAZ {
    private List<Character> list = new ArrayList<>();
    private List<Character> container = Collections.synchronizedList(this.list);
    private String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final Semaphore lock = new Semaphore(1, true);

    public void toVector() {
        for (int i = 0; i < 26; i++) {
            container.add(word.charAt(i));
        }
    }

    public void printWord() {
        while (true) {
            try {
                lock.acquire();
                if (this.container.size() == 0) {
                    break;
                }
                System.out.println("ThreadName: " + Thread.currentThread().getName() + container.remove(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.release();
            }
        }
    }

    public static void main(String[] args) {
        T03_PrintAZ az = new T03_PrintAZ();
        az.toVector();
        new Thread(az::printWord, "Thread-01").start();
        new Thread(az::printWord, "Thread-02").start();
    }

}
