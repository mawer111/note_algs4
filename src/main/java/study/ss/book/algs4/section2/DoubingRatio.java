package study.ss.book.algs4.section2;

import study.ss.book.algs4.std.StdOut;
import study.ss.book.algs4.std.StdRandom;
import study.ss.book.algs4.struct.StopWatch;

public class DoubingRatio {
    private static final int MAXIMUM_INTEGER = 1000000;

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        StopWatch stopWatch = new StopWatch();
        ThreeSumFast.count(a);
        return stopWatch.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
            prev = time;
        }


    }


}
