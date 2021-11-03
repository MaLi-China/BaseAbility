package mchapter03_stack;

/**
 * 功能说明：使用数组实现动态扩容的顺序栈
 * 开发人员：@author MaLi
 */
public class ArrayStackPlus {
    private String[] container;
    private int length;
    private int topPosition;

    /**
     * 默认长度10的栈
     */
    public ArrayStackPlus() {
        this(10);
    }

    /**
     * 指定长度的栈
     *
     * @param length 长度指定
     */
    public ArrayStackPlus(int length) {
        this.length = length;
        this.container = new String[length];
        this.topPosition = -1;
    }

    /**
     * 入栈
     *
     * @param element 入栈元素
     * @return 是否成功入栈
     */
    public boolean push(String element) {
        if (topPosition == length - 1) {
            expansion();
        }
        container[++topPosition] = element;
        return true;
    }

    /**
     * 弹栈
     *
     * @return 栈顶元素
     */
    public String pop() {
        if (topPosition < 0) {
            return null;
        }
        return container[topPosition--];
    }

    /**
     * 扩容为当前容量的2倍
     */
    public void expansion() {
        String[] newContainer = new String[length * 2];
        for (int i = 0; i < length; i++) {
            newContainer[i] = container[i];
        }
        this.length = this.length * 2;
        this.container = newContainer;
    }
}
