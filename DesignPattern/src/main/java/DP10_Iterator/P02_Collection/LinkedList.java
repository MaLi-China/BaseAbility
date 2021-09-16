package DP10_Iterator.P02_Collection;

/**
 * 功能说明：使用链表实现ArrayList
 * 开发人员：@author MaLi
 */
public class LinkedList implements Collection_ {
    private Node head = null;
    private Node tail = null;
    private int index = 0;

    @Override
    public void add(Node o) {
        if (index == 0) {
            head = o;
            tail = head;
        } else {
            tail.setNext(o);
            tail = tail.getNext();
        }
        index++;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {
        private int currentIndex = 0;
        private Node currentNode;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public Object next() {
            if (currentIndex == 0) {
                currentNode = head;
            } else {
                currentNode = currentNode.getNext();
            }
            currentIndex++;
            return currentNode;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Node("Node1"));
        linkedList.add(new Node("Node2"));
        System.out.println(linkedList.size());
        Iterator_ iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
