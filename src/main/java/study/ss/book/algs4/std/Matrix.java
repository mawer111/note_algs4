package study.ss.book.algs4.std;

public class Matrix {


    /**
     * 向量点乘
     *
     * @param x
     * @param y
     * @return
     */
    public static double dot(double[] x, double[] y) {
        double result = .0f;
        for (int i = 0; i < x.length; i++) {
            result = result + x[i] * y[i];
        }
        return result;
    }

    public static double mult(double[][] a, double[][] b) {
        return .0f;
    }




}
