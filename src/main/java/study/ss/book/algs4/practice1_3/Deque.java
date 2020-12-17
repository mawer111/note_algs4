package study.ss.book.algs4.practice1_3;

import study.ss.book.algs4.Practice;

@Practice(value = "1.3.33")
public interface Deque {

    boolean isEmpty();

    int size();

    void pushLeft(Item item);

    void pushRight(Item item);

    Item popLeft();

    Item popRight();


}
