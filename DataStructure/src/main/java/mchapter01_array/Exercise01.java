package mchapter01_array;

/**
 * 面试题: 实现一个支持动态扩容的数组
 * 开发人员：@author MaLi
 */
public class Exercise01 {
    public static void main(String[] args) {
        ArrayPlus arrayPlus = new ArrayPlus(2);
        Object[] objects = arrayPlus.container;
        //初始化
        for (int i = 0; i < objects.length; i++) {
            objects[i] = i;
        }
        System.out.println("Before insert...");
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("After insert!!!");
        // 插入
        arrayPlus.append(100);

        arrayPlus.insert(200, 0);
        arrayPlus.insert(300, 0);
        objects = arrayPlus.container; //重新指向一下, 否则, 变量指向的还是原来的数组
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    static class ArrayPlus {
        private Object[] container; // 存储内容的数组容器
        private int size = 10; // 默认初始容量
        private int currentIndex = 0; // 待插入的位置

        public ArrayPlus() {
            this.container = new Object[size];
        }

        /**
         * 为了性能考虑, 直接初始化好指定的长度, 避免扩容的过程
         *
         * @param size 初始化数组容量
         */
        public ArrayPlus(int size) {
            this.size = size;
            this.container = new Object[size];
        }

        /**
         * 追加元素到数组中
         *
         * @param element 追加的元素
         */
        public void append(Object element) {
            this.insert(element, currentIndex);
        }

        /**
         * 插入元素到数组中
         *
         * @param element  要插入的元素
         * @param position 要插入的位置
         */
        public void insert(Object element, int position) {
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
        private Object[] expansion(Object[] container) {
            size = size * 2;
            // 扩容
            Object[] newContainer = new Object[size];
            // 拷贝
            System.arraycopy(container, 0, newContainer, 0, size / 2);
            return newContainer;
        }
    }
}
