package myframework;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 功能说明：基于队列的点对点消息队列
 * 1, 添加消息
 * 2, 消费消息
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/16
 */
public class MQueue<T> {
    private Queue<T> queue = new ArrayBlockingQueue<>(100);

    public T consume() {
        return queue.poll();
    }

    public boolean produce(T t) {
        return queue.add(t);
    }
}
