package study.ss.book.algs4.sort;

public class InsertSort extends SortBase{

    public void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > 0; j--) {
                swap(arr, i, j);
            }
        }
    }

    public boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void main(String[] args) {




        Integer[] arr = new Integer[]{2, 3, 53, 11, 233, 5546, 656, 1566};

        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);
        insertSort.print(arr);
    }

}
