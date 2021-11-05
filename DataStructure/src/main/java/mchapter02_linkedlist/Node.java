package mchapter02_linkedlist;

/**
 * 功能说明：链表元素-单链表
 * 开发人员：@author MaLi
 */
public class Node<T> {
    private T content;
    private Node next;

    public Node() {
        this.content = null;
        this.next = null;
    }

    public Node(T content) {
        this.content = content;
        this.next = null;
    }

    public Node(T content, Node next) {
        this.content = content;
        this.next = next;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
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
