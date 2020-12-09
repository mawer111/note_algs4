package study.ss.book.algs4.practice1_1;

public class Forbonacci {

    public static long F(int N) {
        if (N < 2) {
            return 1;
        }
        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
            System.out.println(F(N));
            System.out.println("N:" + N);
        }
    }


}
