package ds02.list;

/**
 * 功能说明：单向链表
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/19
 */
public class MSinglyList<T> {
    //容量
    private int size;
    //header节点
    private Node<T> header;
    //tail节点
    private Node<T> tailer;

    public MSinglyList() {
        this.size = 0;
        this.header = new Node<>(null, null);
        this.tailer = new Node<>(null, null);
        header.nextNode = tailer;
    }

    //添加节点
    public boolean append(Node<T> node) {
        if (node == null) {
            return false;
        }
        //遍历链表, 找到tailer的前一个元素
        Node<T> tmp = header;
        while (tmp.nextNode != tailer) {
            tmp = tmp.nextNode;
        }
        tmp.nextNode = node;
        node.nextNode = tailer;
        size++;
        return true;
    }

    //插入节点
    public boolean insert(Node<T> currentNode, Node<T> beforeNode) {
        if (currentNode == null || beforeNode == null) {
            return false;
        }
        //遍历链表, 找到tailer的前一个元素
        Node<T> tmp = header;
        while (tmp.nextNode != beforeNode) {
            tmp = tmp.nextNode;
        }
        tmp.nextNode = currentNode;
        currentNode.nextNode = beforeNode;
        size++;
        return true;
    }

    //是否包含content相等的Node
    public boolean contain(Node<T> node) {
        if (node == null) {
            return false;
        }
        //遍历链表, 找到tailer的前一个元素
        Node<T> tmp = header.nextNode;
        while (tmp != tailer) {
            if (tmp.content == node.content) {
                return true;
            }
            tmp = tmp.nextNode;
        }
        return false;
    }

    //删除节点: 删除第一个等于node的节点
    public boolean deleteNode(Node<T> node) {
        if (node == null) {
            return false;
        }
        //遍历链表, 找到tailer的前一个元素
        Node<T> tmp = header;
        while (tmp.nextNode != tailer) {
            if (tmp.nextNode.content == node.content) {
                tmp.nextNode = node.nextNode;
                return true;
            }
            tmp = tmp.nextNode;
        }
        return false;
    }


}

class Node<T> {
    //节点内容
    Object content;
    //next指针
    Node<T> nextNode;

    public Node(Object content, Node<T> nextNode) {
        this.content = content;
        this.nextNode = nextNode;
    }

    public T getContent() {
        return (T) content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
