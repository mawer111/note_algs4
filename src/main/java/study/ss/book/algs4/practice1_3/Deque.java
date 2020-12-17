package study.ss.book.algs4.practice1_3;

import study.ss.book.algs4.Practice;

@Practice(value = "1.3.33")
public interface Deque<T> {

    boolean isEmpty();

    int size();

    void pushLeft(T item);

    void pushRight(T item);

     T popLeft();

     T popRight();


}
