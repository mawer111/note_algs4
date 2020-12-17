package study.ss.book.algs4.practice1_3;

import study.ss.book.algs4.Practice;

@Practice(value = "1.3.33")
public class LinkDeque implements Deque{

    private Node head;

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
    public void pushLeft(Item item) {
        if (head == null) {
            head = new Node(item);
        }else{
            Node node = new Node(item);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void pushRight(Item item) {
        if (head == null) {
            head = new Node(item);
        }else{
            Node node = new Node(item);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
        size++;
    }

    @Override
    public Item popLeft() {
        if (head.next != null) {
            Node result = head;
            Node next = head.next;
            next.prev = null;
            head.next = null;
            head = next;
            size --;
            return result.v;
        }else{
            size --;
            return head.v;
        }
    }

    @Override
    public Item popRight() {
        return null;
    }

    static class Node{
        Node prev;
        Node next;
        Item v;

        public Node(Item v) {
            this.v = v;
        }
    }

}
