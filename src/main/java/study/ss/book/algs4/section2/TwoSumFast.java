package study.ss.book.algs4.section2;

import study.ss.book.algs4.Algorithm;
import study.ss.book.algs4.BinarySearch;

import java.util.Arrays;

@Algorithm("1.4.5.1")
public class TwoSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int rank = BinarySearch.rank(0 - a[i], a);
            if (rank > 0 && rank > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, -1, -2, 4, -3, 5, 1, 3, -5};
        System.out.println(count(a));
    }



}
