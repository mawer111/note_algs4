package study.ss.book.algs4.practice1_3;

import study.ss.book.algs4.Practice;
import study.ss.book.algs4.practice1_1.RecursionLinkList;

@Practice(value = "1.3.32")
public class Steque<T> {


    private Node<T> head;

    public void push(T v) {
        Node<T> tNode = new Node<T>(v);
        if (head == null) {
            head = tNode;
        }else{
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = tNode;
        }

    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Node<T> pre = null;
        Node<T> temp = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        T result = temp.v;
        if (pre != null) {
            pre.next = null;
        }
        return result;
    }

    public void enqueue(T v) {
        Node<T> tNode = new Node<T>(v);
        if (head == null) {
            head = tNode;
        }else{
            Node t = head;
            head = tNode;
            head.next = t;
        }
    }

    public static void main(String[] args) {
        Steque<Integer> integerSteque = new Steque<Integer>();
        integerSteque.pop();
        integerSteque.push(1);
        integerSteque.push(2);
        System.out.println(integerSteque.pop());
        integerSteque.enqueue(3);
        System.out.println(integerSteque.pop());
    }


    static class Node<T> {

        public Node(T v) {
            this.v = v;
        }

        Node<T> next;
        T v;
    }

}
