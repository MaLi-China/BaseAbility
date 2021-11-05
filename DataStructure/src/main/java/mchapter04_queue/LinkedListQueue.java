package mchapter04_queue;

/**
 * 功能说明：
 * head --> #1 -->...--> #n -->tail
 * 开发人员：@author MaLi
 */
public class LinkedListQueue<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "length=" + length +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public boolean enqueue(T element) {
        //情况1: 如果队列为空
        if (length == 0) {
            tail = new Node<>();
            tail.setContent(element);
            head = tail;
        } else {
            //情况2: 如果队列不为空
            Node<T> newTailNode = new Node<>(element);
            tail.setNext(newTailNode);
            tail = newTailNode;
        }
        this.length++;
        return true;
    }

    public T dequeue() {
        //情况1: 队列为空
        if (length == 0) {
            return null;
        }
        //情况2: 队列不为空
        Node<T> result = head;
        head = head.getNext();
        result.setNext(null);
        length--;
        return result.getContent();
    }


    public static class Node<T> {
        private T content;
        private Node<T> next;

        public Node() {
            this.content = null;
            this.next = null;
        }

        public Node(T content) {
            this.content = content;
            this.next = null;
        }

        public Node(T content, Node<T> next) {
            this.content = content;
            this.next = next;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "content=" + content +
                    ", next=" + next +
                    '}';
        }
    }
}
