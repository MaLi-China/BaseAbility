package mchapter04_queue;

import java.util.Arrays;

/**
 * 功能说明：能够自动扩容的顺序队列
 * 开发人员：@author MaLi
 */
public class ArrayQueue {
    private Object[] container; //队列容器
    private int length; //队列容器长度
    private int head;   //队列首
    private int tail;   //队列尾
    private boolean enableExpansion; //扩容


    public ArrayQueue(int length) {
        this(length, false);
    }

    public ArrayQueue(int length, boolean enableExpansion) {
        this.length = length;
        container = new Object[length];
        head = -1;
        tail = -1;
        this.enableExpansion = enableExpansion;
    }

    /**
     * 入队
     * 放不下的时候, 整理空间或者扩容
     * 放得下, 直接放入
     *
     * @param obj 入队元素
     */
    public boolean enqueue(Object obj) {
        // 1, 如果队列尾已经到达容器最后一个位置
        if (tail == length - 1) {
            //1.1 判断容器是否有空闲空间
            if (tail - head < length - 1) {
                //整理队列: 移动数组的前面的元素
                arrangement();
                //1.2判断是否允许扩容
            } else if (enableExpansion) {
                //没有空间, 允许扩容
                expansion();
            } else {
                //1.3 没有空间, 不允许扩容, 放置失败
                return false;
            }
        }
        if (head == -1) {
            head = 0;//第一次放入元素
        }
        //放入元素
        container[++tail] = obj;
        return true;
    }

    /**
     * 出队
     * 不断弹出head位置的元素
     *
     * @return head位置的元素
     */
    public Object dequeue() {
        Object result = null;
        if (head != tail) {
            //说明队列不为空
            result = container[head];
            container[head++] = null;
        } else if (head != -1) {
            // 说明head与tail指向同一个元素, 且队列不为空
            result = container[head];
            container[head] = null;
            head = -1;
            tail = -1;
        }
        return result;
    }

    /**
     * 没有空间, 扩容
     */
    private void expansion() {
        Object[] newContainer = new Object[length * 2];
        System.arraycopy(container, 0, newContainer, 0, length);
        length *= 2;
        container = newContainer;
    }

    /**
     * 整理队列: 移动数组的前面的元素
     */
    private void arrangement() {
        int offset = head;
        /*for (int i = head; i < tail; i++) {
            container[i - offset] = container[i];
        }*/
        System.arraycopy(container, head, container, 0, tail - head + 1);
        head = 0;
        tail = tail - offset;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "container=" + Arrays.toString(container) +
                '}';
    }
}