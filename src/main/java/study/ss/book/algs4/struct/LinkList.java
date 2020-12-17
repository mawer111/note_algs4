package study.ss.book.algs4.struct;

public class LinkList<T> {

    private Node<T> first;

    private Node<T> tail;

    static class Node<T> {
        Node<T> next;
        T item;
    }

    public void push(T node) {
        Node<T> tNode = new Node<T>();
        tNode.item = node;
        push(tNode);

    }
    public void push(Node node) {
        node.next = first;
        this.first = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void deleteFirst() {
        if (first == null) {
            return;
        }
        this.first = first.next;
    }

    /**
     * add a node on tail
     * @param node
     */
    public void pushTail(Node node) {
        this.tail.next = node;
        this.tail = node;
    }


    /**
     * 反转一个链表
     *
     * @param first
     * @return
     */
    public static Node reverse(Node first) {

        Node node = new Node();
        node.next = first;

        first = node;
        Node p = first;
        Node cur = first.next;
        Node temp = null;

        while (cur != null) {

            p.next = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = p.next;
        }

        return node.next;
    }


    public static void main(String[] args) {

        Node<Integer> integerNode = new Node<Integer>();
        integerNode.item = 1;

        Node<Integer> integerNode2 = new Node<Integer>();
        integerNode2.item = 2;

        Node<Integer> integerNode3 = new Node<Integer>();
        integerNode3.item = 3;

        Node<Integer> integerNode4 = new Node<Integer>();
        integerNode4.item = 4;
        integerNode.next = integerNode2;
        integerNode2.next = integerNode3;
        integerNode3.next = integerNode4;

        Node reverse = reverse(integerNode);
        Node c = reverse;
        while (c != null) {
            System.out.println(c.item);
            c = c.next;
        }


    }


    public Integer max(Node<Integer> first) {
        Node<Integer> max = first;
        Node<Integer> cur = first;

        while (cur != null) {
            if (cur.item > max.item) {
                max = cur;
            }
            cur = cur.next;
        }
        return max.item;
    }

    public Integer maxReserve(Node<Integer> node, Integer max) {
        if (node == null) {
            return max;
        }
        if (node.item > max) {
            max = node.item;
        }
        return maxReserve(node.next,max);
    }


    public void insertAfter(Node<T> first, Node<T> second) {
        second.next = this.first;
        this.first = second;
        first.next = second;
    }


    public void removeAfter(Node<T> node) {
        Node<T> cur = first;
        while (cur != null) {
            if (cur == node) {
                cur.next = null;
                return;
            }
            cur = cur.next;
        }
    }

}
