package mchapter03_stack;

/**
 * 功能说明：实现顺序栈
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 * 开发人员：@author MaLi
 */
public class ArrayStack<T> {
    private Object[] container;
    private int length;
    private int index;

    public ArrayStack(int length) {
        this.length = length;
        this.index = 0;
        this.container = new Object[length];
    }

    public boolean push(T t) {
        boolean isSuccess = false;
        if (this.index < length) {
            container[index++] = t;
            isSuccess = true;
        }
        return isSuccess;
    }

    public T pop() {
        T t = null;
        if (this.index > 0) {
            t = (T) container[--index];
        }
        return t;
    }
}