package study.ss.book.algs4.struct;

public class Stack<T> {

    private Node<T> first;

    static class Node<T> {
        Node<T> next;
        T item;
    }

    public Node<T> peek() {
        if (first == null) {
            return null;
        }
        return this.first;
    }

    public void push(T v) {
        Node<T> tNode = new Node<T>();
        tNode.item = v;
        tNode.next = first;
        this.first = tNode;
    }

    public T pop() {
        if (this.first == null) {
            return null;
        }
        T v = this.first.item;
        this.first = this.first.next;
        return v;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>();
        stringStack.push("1234");
        stringStack.push("1232");
        stringStack.push("1233");
        stringStack.push("1231");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());

    }




}
