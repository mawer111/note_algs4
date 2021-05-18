package learn.other;

import java.util.concurrent.atomic.AtomicReference;

public class ConCurrentStack {

    AtomicReference<Node> head = new AtomicReference<>();

    public Node pop() {
        while (true){
            Node node = head.get();
            Node newHead = node.next;

            if (head.compareAndSet(node, newHead)) {
                return node;
            }
        }
    }

    public void push(Node node) {
        while (true) {
            Node old = head.get();
            node.next = old;
            if (head.compareAndSet(old, node)){
                break;
            }
        }



    }




    static class Node {
        Node next;
    }


}
