package study.ss.book.algs4.struct;

public class DoubleLinkList<T> {


    private DNode<T> first;
    private DNode<T> tail;

    private int size;

    public static class DNode<T>{
        T item;
        DNode<T> prev;
        DNode<T> next;
    }

    public void addArray(T[] array) {
        for (T t : array) {
            addTail(t);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        DNode<T> n = first;
        while (n != null) {
            stringBuilder.append(n.item.toString());
            stringBuilder.append(",");
            n = n.next;
        }
        stringBuilder.append("]");


        return stringBuilder.toString();
    }

    /**
     * 翻转链表
     */
    public void reverse() {
        DNode node = first;

        DNode reverse = null;

        while (node != null) {
            DNode temp = node.next;
            node.next = reverse;
            reverse = node;
            node.prev = temp;
            temp.next = node;
            reverse.prev = node;
            node = temp;
        }

        this.first = reverse;
    }


    public int max() {
        DNode n = first;
        int max = 0;
        while (n != null) {
            if (n.item instanceof Integer && (Integer)n.item > max) {
                max = (Integer) n.item;
            }
            n = n.next;
        }
        return max;
    }


    public int maxRR() {
        return maxR(first, 0);
    }

    /**
     * 递归求最大
     *
     * @return
     */
    public int maxR(DNode node,int max) {
        if (node == null) {
            return max;
        }
        Integer v = (Integer) node.item;
        if (v > max) {
            max = v;
        }

        return maxR(node.next, max);
    }

    public DNode delete(int index) {
        if (first == null) {
            return null;
        }
        DNode<T> tdNode = get(index);
        tdNode.prev.next = tdNode.next;
        tdNode.next.prev = tdNode.prev;
        return tdNode;
    }

    public DNode<T> get(int index) {
        if (first == null) {
            return null;
        }
        if (index > size) {
            throw new IndexOutOfBoundsException("linkedlist size is " + size + ",index:" + index);
        }
        DNode temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public void addFirst(T item) {
        DNode<T> node = new DNode<T>();
        node.item = item;
        node.next = first;
        first.prev = node;
        this.first = node;
    }

    public void addTail(T item) {
        DNode<T> dNode = new DNode<T>();
        dNode.item = item;

        if (tail == null) {
            tail = dNode;
            if (first == null) {
                first = dNode;
            }
            size ++;
            return;
        }

        dNode.prev = tail;
        tail.next = dNode;
        this.tail = dNode;
        size ++;
    }

    public DNode removeTail() {
        if (tail == null) {
            return null;
        }
        DNode temp = tail;
        tail = tail.prev;
        tail.next = null;
        return temp;
    }

    public DNode removeFirst() {
        if (first == null) {
            return null;
        }
        DNode temp = first;
        first = first.next;
        first.prev = null;
        return temp;
    }

    public static void main(String[] args) {
        Integer[] arrs = {1, 2, 3, 1, 9};
        DoubleLinkList<Integer> stringDoubleLinkList = new DoubleLinkList<Integer>();
        stringDoubleLinkList.addArray(arrs);
        System.out.println(stringDoubleLinkList.toString());
        stringDoubleLinkList.reverse();
        System.out.println(stringDoubleLinkList.toString());
    }



}
