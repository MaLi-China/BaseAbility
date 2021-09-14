package DP10_Iterator.P01_Collection;

/**
 * 功能说明: 使用数组实现的ArrayList
 * 开发人员：@author MaLi
 */
public class ArrayList implements Collection_ {
    private Object[] container = new Object[10];
    private int index; //当前写入位置

    @Override
    public void add(Object o) {
        if (index == container.length) {
            //扩容
            Object[] newContainer = new Object[container.length * 2];
            //把历史数据拷贝到新容器中
            System.arraycopy(container, 0, newContainer, 0, container.length);
            container = newContainer;
        }
        container[index++] = o;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex <= index;
        }

        @Override
        public Object next() {
            return container[currentIndex++];
        }
    }
}
