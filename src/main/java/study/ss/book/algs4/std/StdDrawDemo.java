package study.ss.book.algs4.std;

import study.ss.book.algs4.std.StdDraw;

import java.awt.*;

public class StdDrawDemo {

    public static void main(String[] args) {
        drawRandomArray();
    }


    public static void drawRandomArray() {
        int N = 50;
        double[] a = new double[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }

        for (int i = 0; i < N; i++) {
            double x = i / N;
            double y = a[i];
            double rw = 0.5 / N;
            double rh = a[i];

            StdDraw.filledRectangle(x, y, rw, rh);
        }

    }

    public static void drawSqrt() {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, i);

            StdDraw.setPenColor(Color.blue);
            StdDraw.point(i, i * i);

            StdDraw.setPenColor(Color.green);
            StdDraw.point(i,Math.log(i));
        }
    }

}
