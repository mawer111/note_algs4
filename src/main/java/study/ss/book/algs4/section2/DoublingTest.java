package study.ss.book.algs4.section2;

import study.ss.book.algs4.Practice;
import study.ss.book.algs4.std.StdDraw;
import study.ss.book.algs4.std.StdOut;
import study.ss.book.algs4.std.StdRandom;
import study.ss.book.algs4.struct.StopWatch;

import java.awt.*;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    public static double timeTrial(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        StopWatch stopWatch = new StopWatch();
        ThreeSum.count(a);
        return stopWatch.elapsedTime();
    }

    @Practice("1.4.3")
    public static void main(String[] args) {
        StdDraw.setYscale(0,2);
        StdDraw.setXscale(0,10000);
        double prev = timeTrial(125);
        drawLines(125,prev);

        for (int n = 250;true;n += n){
            double time = timeTrial(n);
            drawLines(n,time);
            StdOut.printf("%7d %7.1f %5.1f\n",n,time,time/prev);
            prev =time;
        }
    }
    public static void drawLines(double x,double y){
        drawStandLine(x, y);
        drawLogLine(x,Math.log(y));
    }

    static double lastPointX = 0;
    static double lastPointY = 0;
    public static void drawStandLine(double x,double y) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(lastPointX,lastPointY,x,y);
        lastPointX = x;
        lastPointY = y;
    }
    static double lastLogPointX = 0;
    static double lastLogPointY = 0;
    public static void drawLogLine(double x,double y) {
        StdDraw.setPenColor(Color.RED);
        StdDraw.line(lastLogPointX,lastLogPointY,x,y);
        lastLogPointX = x;
        lastLogPointY = y;
    }

}
