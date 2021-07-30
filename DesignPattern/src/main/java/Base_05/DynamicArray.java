package Base_05;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class DynamicArray {
    private static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected int capacity = DEFAULT_CAPACITY;
    protected Integer[] elements = new Integer[capacity];

    public int getSize() {
        return size;
    }

    public Integer get(int index) {
        return elements[index];
    }

    public void add(Integer e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public void ensureCapacity() {
        //扩容逻辑
    }
}
