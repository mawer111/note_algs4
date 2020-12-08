package study.ss.book.algs4;

/**
 * 查找最大公约数
 */
public class Gcd {

    public static int gcd(int a, int b) {
        int m = a % b;
        if (m != 0) {
            return gcd(b, m);
        }else{
            return b;
        }
    }

    public static int gcd2(int a, int b) {
        int m = a % b;
        int temp = b;
        while (m != 0) {
            int t = m;
            m = temp % m;
            temp = t;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(gcd2(12,6));
    }


}
