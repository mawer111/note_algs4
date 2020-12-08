package study.ss.book.algs4.sort;

public class SelectionSort extends SortBase{

    public void sort(Comparable[] a) {
        for (int  i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        Integer[] arr = {3, 1, 7, 2, 9, 10};
        selectionSort.sort(arr);
        System.out.println(selectionSort.valid(arr));
        Integer[] a2 = {1, 1, 2,1};
        System.out.println(selectionSort.valid(a2));
    }




}
