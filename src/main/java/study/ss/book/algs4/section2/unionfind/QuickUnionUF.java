package study.ss.book.algs4.section2.unionfind;

public class QuickUnionUF implements UF {

    int[] arr;
    int count = 0;

    public QuickUnionUF(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        count = n;
    }

    /**
     * 数组arr中存放根节点的id
     * @param i
     * @return
     */
    private int root(int i) {
        while (arr[i] != i) i = arr[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        /**
         * p的根节点 指向q的根节点，将p所在的树，添加到q上
         */
        arr[rp] = rq;
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int count() {
        return count;
    }
}
