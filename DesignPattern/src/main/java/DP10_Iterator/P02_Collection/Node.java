package DP10_Iterator.P02_Collection;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Node {
    private Object content;
    private Node next;

    public Node(Object content) {
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

    @Override
    public String toString() {
        return "Node{" +
                "content=" + content +
                ", next=" + next +
                '}';
    }
}
