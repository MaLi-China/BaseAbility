package mchapter01_array;

/**
 * 面试题: 实现一个支持动态扩容的数组
 * 开发人员：@author MaLi
 */
public class Exercise01 {
    static class ArrayPlus<T> {
        private T[] container;
        private int size = 10;
        private int currentIndex = 0;

        public ArrayPlus() {
            this.container = (T[]) new Object[size];
        }

        /**
         * 为了性能考虑, 直接初始化好指定的长度, 避免扩容的过程
         *
         * @param size 初始化数组容量
         */
        public ArrayPlus(int size) {
            this.size = size;
            this.container = (T[]) new Object[size];
        }

        /**
         * 追加元素到数组中
         *
         * @param element 追加的元素
         */
        public void append(T element) {
            this.insert(element, currentIndex);
        }

        /**
         * 插入元素到数组中
         *
         * @param element  要插入的元素
         * @param position 要插入的位置
         */
        public void insert(T element, int position) {
            //1, 判断容量是否到达上限
            checkContainerSize();
            //2, 插入
            if (position == currentIndex) {
                //2.1, 插入到末尾
                container[currentIndex++] = element;
            } else if (position < currentIndex) {
                //2.2, 插入到中间
                //1, 拷贝
                System.arraycopy(this.container, position, this.container, position + 1, currentIndex - position);
                //2, 插入
                container[position] = element;
                //3, 增加容量index
                currentIndex++;
            } else {
                throw new IllegalArgumentException("Argument'position' is not correct.");
            }
        }

        /**
         * 判断是否需要扩容
         */
        private void checkContainerSize() {
            if (currentIndex == size) {
                //扩容
                container = this.expansion(container);
            }
        }

        /**
         * 扩容
         *
         * @param container 要被扩容的数组
         * @return 返回扩容后的新数组
         */
        private T[] expansion(T[] container) {
            size = size * 2;
            // 扩容
            T[] newContainer = (T[]) new Object[size];
            // 拷贝
            System.arraycopy(container, 0, newContainer, 0, size - 1);
            return newContainer;
        }
    }
}
