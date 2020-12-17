package study.ss.book.algs4.practice1_3;

import study.ss.book.algs4.Practice;

@Practice(value = "1.3.33")
public class LinkDeque<T> implements Deque<T>{

    private Node<T> head;

    private Node<T> tail;

    private int size;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public void pushLeft(T item) {
        if (head == null) {
            tail = head = new Node(item);
        }else{
            Node node = new Node(item);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void pushRight(T item) {
        if (head == null) {
            tail = head = new Node(item);
        }else{
            Node node = new Node(item);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public T popLeft() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            Node<T> res = head;
            head = tail = null;
            size --;
            return res.v;
        }
        Node<T> result = head;
        head.next.prev = null;
        head = head.next;
        size --;
        return result.v;
    }

    @Override
    public T popRight() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            Node<T> res = head;

            head = tail = null;
            size --;
            return res.v;
        }
        Node<T> result = tail;
        tail.prev.next = null;
        tail = tail.prev;
        size --;
        return result.v;
    }

    static class Node<T>{
        Node prev;
        Node next;
        T v;

        public Node(T v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        LinkDeque<Integer> integerLinkDeque = new LinkDeque<Integer>();
        integerLinkDeque.pushLeft(1);
        integerLinkDeque.pushLeft(2);
        System.out.println(integerLinkDeque.popLeft());
        System.out.println(integerLinkDeque.popLeft());
    }

}
