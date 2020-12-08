package study.ss.book.algs4;


import java.io.File;
import java.util.Arrays;

public class BinarySearch {

    public static int rankFormat(int t, int[] src) {
        int lo = 0;
        int hi = src.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (t > src[mid]) lo = mid + 1;
            else if (t < src[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }


    public static int rank2(int t, int src[]) {
        int lo = 0;
        int hi = src.length - 1;
        while (lo <= hi) {
            /**
             * 中值计算
             * lo + (hi - lo) / 2 而不是 (hi + lo)/2 可以防止数据溢出
             */
            int mid = lo + (hi - lo) / 2;
            int v = src[mid];
            if (v == t) {
                return mid;
            } else if (v < t) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        throw new IllegalArgumentException();
    }


    public static int rank(int t, int src[]) {
        int lo = 0;
        int hi = src.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int v = src[mid];
            if (t == v) {
                return mid;
            }
            if (t > v) {
                lo = mid + 1;
            } else if (t < v) {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static File getTextFile(String fileName) {
        return new File("/Users/ss/Downloads/algs4-data/" + fileName);
    }

    public static void main(String[] args) {
        In in = new In(getTextFile("tinyW.txt"));
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int rank = rankFormat(key, whitelist);
            StdOut.println(rank);
        }
    }

}
