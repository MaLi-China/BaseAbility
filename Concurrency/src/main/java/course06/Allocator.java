package course06;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：使用等待通知机制, 解决while轮训
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/7
 */
public class Allocator {
    private List<Object> list = new ArrayList<>();

    public synchronized boolean apply(Object from, Object to) {
        while (list.contains(from) || list.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(from);
        list.add(to);
        return true;
    }

    public synchronized void free(Object from, Object to) {
        list.remove(from);
        list.remove(to);
        notifyAll();
    }
}
