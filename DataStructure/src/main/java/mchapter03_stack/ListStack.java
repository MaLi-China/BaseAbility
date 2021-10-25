package mchapter03_stack;

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
