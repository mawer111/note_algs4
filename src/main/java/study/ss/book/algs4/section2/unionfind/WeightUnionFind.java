package study.ss.book.algs4.section2.unionfind;

public class WeightUnionFind implements UF {

    int arr[];
    /**
     * 保存树的深度
     */
    int sz[];

    public WeightUnionFind(int n) {
        arr = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (arr[i] != i) i = arr[i];
        return i;
    }


    @Override
    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if (rp == rq) return;
        /**
         * p的高度小于q的高度，将p的树添加到q上
         * 再维护q树的高度
         */
        if (sz[rp] < sz[rq]){
            arr[rp] = rq;
            sz[rq] += sz[rp];
        }else{
            arr[rq] = arr[rp];
            sz[rp] += sz[rq];
        }
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
