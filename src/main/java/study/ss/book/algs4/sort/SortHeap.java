package study.ss.book.algs4.sort;

public class SortHeap extends SortBase {


    private Comparable[] arr;

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private void exch(int i, int j) {
        Comparable comparable = arr[i];
        arr[i] = arr[j];
        arr[j] = comparable;
    }


}
