package study.ss.book.algs4.struct;

import study.ss.book.algs4.Algorithm;

@Algorithm("1.4.1")
public class StopWatch {

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
