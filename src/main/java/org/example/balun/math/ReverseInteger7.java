package org.example.balun.math;

public class ReverseInteger7 {

    public static void main(String[] args) {
        reverse(-123);

    }
    static public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int i = x % 10;
            res = res * 10 + i;
            x = x / 10;
        }
        if (res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE) {
            return (int) res;
        }
        return 0;
    }
}
