package study.ss.book.algs4.section2;

import study.ss.book.algs4.Algorithm;
import study.ss.book.algs4.std.In;
import study.ss.book.algs4.std.StdOut;

import java.io.File;

@Algorithm("1.4.2.1")
public class ThreeSum {

    public static int count(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] == -a[k]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(new File(args[0]));
        int[] ints = in.readAllInts();
        StdOut.println(count(ints));
    }



}
