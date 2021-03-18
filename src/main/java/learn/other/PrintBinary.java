package learn.other;

public class PrintBinary {
    public static void main(String[] args) {
        int i = 1;
        i <<= 30;
        int a = 0b01 << 30;
        System.out.println(a);
        printBinary(a);
        System.out.println(Integer.toBinaryString(a));
    }

    static char[] digits = new char[]{
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
    };

    public static void printBinary(int n) {
        char[] cs = new char[32];
        int length = 32;
        while (n > 0) {
            cs[--length] = digits[n & 0x1];
            n >>= 0x01;
        }
        System.out.println(new String(cs));
    }
}
