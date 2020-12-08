package study.ss.book.algs4.struct;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;


    static class Node<T> {
        Node<T> next;
        T item;
    }


    public void enQueue(T v) {
        Node<T> tNode = new Node<T>();
        tNode.item = v;
        if (last != null) {
            last.next = tNode;
            last = tNode;
        }else{
            this.last = tNode;
        }
        if (first == null) {
            this.first = last;
        }
    }


    /**
     * 从队首出元素
     *
     * @return
     */
    public T deQueue() {
        if (first == null) {
            return null;
        }
        T v = this.first.item;
        this.first = first.next;
        return v;
    }




}
