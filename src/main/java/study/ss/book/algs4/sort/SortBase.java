package study.ss.book.algs4.sort;

public class SortBase {

    public boolean valid(Comparable[] a) {
        Comparable before = null;
        for (int i = 0; i < a.length; i++) {
            if (before != null) {
                if (before.compareTo(a[i]) > 0) {
                    return false;
                }
            }
            before = a[i];
        }
        return true;
    }

    /**
     * 将数组中的元素插入到指定索引上,索引右侧的元素需要整体向右移动
     * @param arr
     * @param idxTarget
     * @param idxSource
     */
    public void insert(Comparable[] arr, int idxTarget, int idxSource) {
        Comparable v = arr[idxSource];
        Comparable temp = arr[idxTarget];
        for (int i = idxTarget + 1; i < arr.length; i++) {
            Comparable last = arr[i];
            arr[i] = temp;
            temp = last;
        }
        arr[idxTarget] = v;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 4, 5, 6, 7, 12};
        SortBase sortBase = new SortBase();
        sortBase.print(a);
        sortBase.insert(a, 3, 0);
        sortBase.print(a);
    }

    public void print(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
