package study.ss.book.algs4.practice1_1;

import study.ss.book.algs4.std.StdOut;

import java.util.ArrayList;

public class RecursionLinkList {


    public static void main(String[] args) {
        Node n1 = assemblyOrderNode(5);
        Node t = n1;
        ArrayList<Node> nodes = new ArrayList<Node>();
        while (t != null) {
            nodes.add(t);
            t = t.next;
        }
        print(n1);
        StdOut.println();
        Node node = reversePartNode(n1,2,4);
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
     * 部分翻转链表
     * @param node
     * @param m
     * @param n
     * @param <T>
     * @return
     */
    public static <T> Node<T> reversePartNode(Node<T> node, int m, int n) {
        Node head = node;
        Node prev = null;

        Node conn = null;
        Node tail = null;

        Node cur = node;

        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        conn = prev;
        tail = cur;

        while (n > 0) {
            Node t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
            n--;
        }

        if (conn != null) {
            conn.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;

        return head;
    }



    /**
     * 递归翻转链表
     * 把递归分成 递和归两个步骤考虑
     *
     * 递：f(n) = if n.next != null f(n.next) else return n
     *
     * 归:
     * 在归的过程中将每个节点和他的后继翻转
     * 实际是将单链表从后向前遍历
     *
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
