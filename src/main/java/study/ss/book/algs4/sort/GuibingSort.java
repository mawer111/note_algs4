package study.ss.book.algs4.sort;

public class GuibingSort extends SortBase {


    public void merge(Comparable[] a, int lo, int hi, int mid) {
        Comparable[] aux = new Comparable[hi - lo];
        for (int i = lo; i < hi; i++) {
            int j = i + mid;
            if (a[i].compareTo(a[j]) < 0) {


            }
        }

    }

    public static void main(String[] args) {
        int N = 10;
        int workCount = 0;

        for (int i = 0; i < N; i++) {          //外层执行次数 N
            for (int j = 0; j < N; j++) {     //执行次数N
                workCount ++;                //执行次数 N + N + N + 。。。 +N 共N次相加 N * N
            }
        }
        System.out.println(workCount);

        int K = 0;
        for (int i = 0; i < N; i++) {                 //外层执行次数 N
            for (int j = i + 1; j < N; j++) {        //内层执行次数 (N - i - 1) + ( N - 2) + ( N - 3) + ... + (0)
                K ++;                               //执行次数 等差数列公式 Sn = N (N - 1 )
            }
        }
        System.out.println(K);
    }

}
