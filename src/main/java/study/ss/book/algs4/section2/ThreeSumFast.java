package study.ss.book.algs4.section2;

import study.ss.book.algs4.Algorithm;
import study.ss.book.algs4.BinarySearch;

import java.util.Arrays;
@Algorithm("1.4.5.2")
public class ThreeSumFast {

    public static int count(int[] a) {
        int n = a.length;
        int cnt = 0;
        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (BinarySearch.rank(0 - a[i] - a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
