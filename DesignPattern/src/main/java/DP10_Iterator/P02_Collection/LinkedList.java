package DP10_Iterator.P02_Collection;

/**
 * 功能说明：使用链表实现ArrayList
 * 开发人员：@author MaLi
 */
public class LinkedList implements Collection_ {
    private Node head = null;
    private Node tail = head;
    private int index = 0;

    @Override
    public void add(Node o) {
        if (index == 0) {
            head = o;
        } else {
            tail.setNext(o);
            tail = o;
            index++;
        }
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_ iterator() {
        return null;
    }

    private class LinkedListIterator implements Iterator_ {
        private int currentIndex = 0;
        private Node currentNode;

        @Override
        public boolean hasNext() {
            return index < currentIndex;
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
}
