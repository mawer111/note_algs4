package study.ss.book.algs4.practice1_1;

import study.ss.book.algs4.std.StdOut;
import study.ss.book.algs4.std.StdRandom;

public class Answer {

    public static void main(String[] args) {
//        int[][] random = randomI(10, 10);
////        printBooleanArr(random);
//        printArr(random);
//        StdOut.println("--------------------------");
//        reverse(random);
//        System.out.println(lg(32));
//        int[] ints = randomI(20);
//        StdOut.println(ints);
//        StdOut.println(histogram(ints,4));
        System.out.println(exR1(6));
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static int[] histogram2(int[] a, int M) {
        int[] result = new int[M];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < M) {
                result[a[i]] ++;
            }
        }

        return result;
    }


    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];

        for (int i = 0; i < M - 1; i++) {
            result[i] = count(a, i);
        }
        return result;
    }

    public static int count(int[] a, int t) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t) {
                result ++;
            }
        }
        return result;

    }


    public static void printArr(int[][] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                StdOut.print(src[i][j]);
                StdOut.print(" ");
            }
            StdOut.println();
        }
    }

    /**
     * practice1.1.13
     *
     * @param src
     */
    public static void reverse(int[][] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                StdOut.print(src[j][i]);
                StdOut.print(" ");
            }
            StdOut.println();
        }
    }

    /**
     * practice 1.1.14
     *
     * @param N
     */
    public static int lg(int N) {
        int i = 0;
        int m = 1;
        while (m <= N) {
            m = m * 2;
            i ++;
        }
        return i - 1;
    }


    public static void printBooleanArr(boolean[][] b) {

        StdOut.print("  ");
        for (int x = 0; x < b.length; x++) {
            StdOut.print(x);
        }
        StdOut.println();


        for (int i = 0; i < b.length; i++) {
            StdOut.print(i);
            StdOut.print(" ");
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j]) StdOut.print("*");
                else StdOut.print(" ");
            }
            StdOut.println();
        }

    }
    public static int[] randomI(int length) {
        int[] b = new int[length];
        for (int i = 0; i < b.length; i++) {
            int uniform = StdRandom.uniform(10);
            b[i] = uniform;
        }
        return b;
    }
    public static int[][] randomI(int rows, int columns) {
        int[][] b = new int[rows][columns];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                int uniform = StdRandom.uniform(10);
                b[i][j] = uniform;
            }
        }
        return b;
    }


    public static boolean[][] random(int rows, int columns) {
        boolean[][] b = new boolean[rows][columns];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                double uniform = StdRandom.uniform();
                b[i][j] = uniform > .5;
            }
        }
        return b;
    }

}
