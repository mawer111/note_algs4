package study.ss.book.algs4.practice1_1;

import study.ss.book.algs4.std.StdOut;

import java.util.ArrayList;

public class RecursionLinkList {


    public static void main(String[] args) {
        Node n1 = assemblyOrderNode(4);
        Node t = n1;
        ArrayList<Node> nodes = new ArrayList<Node>();
        while (t != null) {
            nodes.add(t);
            t = t.next;
        }
        print(n1);
        StdOut.println();
        Node node = reverseNode(n1);
        print(node);
    }

    /**
     * 循环翻转链表
     * node指向当前节点，将node遍历过的视为已经翻转过的节点，所以只需要将当前节点的next指向之前的节点
     *
     * node
     * ⬇️
     * 1 -> 2 -> 3 -> 4
     *
     * node                  node
     * ⬇️                     ⬇️
     * 2 -> 3 -> 4   ---->    3 -> 4 -> null
     *
     * pre                   pre
     * ⬇️                     ⬇️
     * 1 -> null     ---->    2 -> 1 -> null
     *
     *
     *
     *
     * 循环翻转链表
     * @param node
     * @param <T>
     * @return
     */
    public static <T> Node<T> reverseNode(Node<T> node) {
        Node pre = null;
        while (node != null) {
            Node t = node.next;
            node.next = pre;
            pre = node;
            node = t;
        }
        return pre;
    }


    /**
     * 递归翻转链表
     * @param node
     * @param <T>
     * @return
     */
    public static <T> Node<T> recursionNode(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newNode = recursionNode(node.next);
        Node t = node.next;
        t.next = node;
        node.next = null;

        return newNode;
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
