package study.ss.book.algs4.section2.unionfind;

import study.ss.book.algs4.std.StdIn;

public class QuickFindUF implements UF {

    private int[] arr;
    int count = 0;

    public QuickFindUF(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        count = n;
    }

    @Override
    public void union(int p, int q) {
        int ip = find(p);
        int iq = find(q);
        if (ip == iq) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ip) arr[i] = iq;
        }
        count--;
    }

    @Override
    public int find(int p) {
        return arr[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF quickFindUF = new QuickFindUF(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!quickFindUF.connected(p, q)) {
                quickFindUF.union(p,q);
            }
        }
    }
}
