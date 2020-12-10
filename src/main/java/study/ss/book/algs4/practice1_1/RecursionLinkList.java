package study.ss.book.algs4.practice1_1;

import study.ss.book.algs4.std.StdOut;

public class RecursionLinkList {


    public static void main(String[] args) {
        Node n1 = assemblyOrderNode(4);
        print(n1);
        StdOut.println();
        recursionNode(n1);
        print(n1);
    }

    public static <T> Node<T> recursionNode(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newNode = recursionNode(node.next);
        newNode.next = node;
//        print(newNode);
        return node;
    }

    static class Node<T> {

        public Node(T v) {
            this.v = v;
        }

        Node<T> next;
        T v;
    }

    public static Node assemblyOrderNode(int max) {
        Node head = null;
        Node pre = null;
        int cur = 1;
        while (cur <= max) {
            Node<Integer> n = new Node<Integer>(cur);
            if (pre != null) {
                pre.next = n;
            }else {
                head = n;
            }
            pre = n;
            cur ++;
        }
        return head;
    }

    public static void print(Node node) {
        if (node == null) {
            StdOut.println("null");
        }
        while (node != null) {
            StdOut.print(node.v.toString());
            if (node.next != null) {
                StdOut.print(" ->");
            }
            node = node.next;
        }
        StdOut.println();
    }

}
