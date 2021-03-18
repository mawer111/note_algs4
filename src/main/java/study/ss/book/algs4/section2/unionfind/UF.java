package study.ss.book.algs4.section2.unionfind;

/**
 * 并查集
 */
public interface UF {

    /**
     * 在p q之间添加一条链接
     * @param p
     * @param q
     */
    void union(int p, int q);


    int find(int p);

    /**
     * p和q之间是否链接
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     * 联通分量的数量
     * @return
     */
    int count();


}
