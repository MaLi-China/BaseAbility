package mchapter04_queue;

/**
 * 功能说明：循环队列
 * 开发人员：@author MaLi
 */
public class CircleQueue {

    private Object[] container;
    private int head;
    private int tail;
    private int length;

    public CircleQueue(int length) {
        this.length = length + 1;
        this.container = new Object[this.length];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 出队
     * 队列为空条件: head与tail相等
     *
     * @return 队列的head位置元素
     */
    public Object deQueue() {
        Object result = null;
        if (head == tail) {
            return null;
        } else {
            result = container[head];
            container[head] = null;
            //check: head是否在0位置
            head = head == (length - 1) ? 0 : ++head;
        }
        return result;
    }

    /**
     * 入队
     * 队列为满条件: (tail+1)%length=head
     * +1的目的: 防止tail在0的位置
     * tail始终指向
     *
     * @param element 入队元素
     */
    public boolean enQueue(Object element) {
        if ((tail + 1) % length == head) {
            return false;
        } else {
            container[tail] = element;
            tail = tail == (length - 1) ? 0 : ++tail;
            return true;
        }
    }
}
