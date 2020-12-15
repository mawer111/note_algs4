package study.ss.book.algs4.section2;

import java.util.ArrayList;
import java.util.List;

public class ArrayCovariance {

    public static void main(String[] args) {
        Number[] ns = new Number[10];

        ns[0] = new Integer(10);
        ns[1] = new Double(.1f);
        Integer[] is = new Integer[10];
        ns = is;
        ns[1] = new Double(.2f);

        System.out.println(ns[0]);
        System.out.println(ns[1]);
        List<? super Number> myints = new ArrayList();

    }

}
