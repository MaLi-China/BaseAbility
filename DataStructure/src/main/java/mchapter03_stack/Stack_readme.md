# 栈Stack

> 是什么?用来干什么?

## 1, 概述

栈: 一种操作受限的线性表结构, 只能在一端对数据进行入栈和出栈操作.

栈的实现方式: 顺序栈, 链式栈, 分别用数组和链表实现.

## 2, 实战

### 2.1 实现顺序栈

固定长度的栈

```java
/**
 * 功能说明：使用数组实现"固定长度"的顺序栈
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 * 开发人员：@author Mark
 */
public class ArrayStack {
    private String[] container;
    private int topLocation;
    private int size;

    public ArrayStack(int size) {
        this.size = size;
        container = new String[size];
        this.topLocation = -1;
    }

    public String pop() {
        if (topLocation < 0) {
            return null;
        }
        return container[topLocation--];
    }

    public boolean push(String element) {
        if (topLocation == size - 1) {
            return false;
        }
        container[++topLocation] = element;
        return true;
    }
}
```

自动扩容的顺序栈

```java
/**
 * 功能说明：使用数组实现动态扩容的顺序栈
 * 时间复杂度: O(1) (有人觉得这里应该是O(n), 其实都不对, 时间复杂度应该一般指的是平均时间复杂度, 并非最好和最坏)
 * 空间复杂度: O(1) 
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
     * @param length 长度指定
     */
    public ArrayStackPlus(int length) {
        this.length = length;
        this.container = new String[length];
        this.topPosition = -1;
    }

    /**
     * 入栈
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
```

### 2.2 实现链式栈

```java
/**
 * 功能说明：链式栈
 * 时间复杂度: O(1)
 * 空间复杂度: O(n)
 * 开发人员：@author MaLi
 */
public class ListStack<T> {
    private Node<T> currentNode;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public ListStack() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.currentNode = new Node<>(null);
        head.setNext(currentNode);
        head.setForward(null);
        tail.setNext(null);
        tail.setForward(currentNode);
        currentNode.setForward(head);
        currentNode.setNext(tail);
        this.size = 0;
    }

    public boolean push(Node<T> node) {
        try {
            Node forward = currentNode.getForward();
            Node next = currentNode.getNext();

            forward.setNext(node);
            next.setForward(node);

            node.setForward(forward);
            node.setNext(next);

            currentNode = node;
            size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Node<T> pop() {
        Node result = null;
        if (size > 0) {
            result = currentNode;
            Node forward = currentNode.getForward();
            forward.setNext(currentNode.getNext());
            size--;
        }
        return result;
    }

    public static class Node<T> {
        private Object content;
        private Node next;
        private Node forward;

        public Node getForward() {
            return forward;
        }

        public void setForward(Node forward) {
            this.forward = forward;
        }

        public Node(T content) {
            this.content = content;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
```

## 3, 应用场景

1, 函数调用

2, 表达式求值

3, 括号匹配

4, 浏览器前进后退功能
