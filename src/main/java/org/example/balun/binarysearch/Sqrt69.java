package org.example.balun.binarysearch;

public class Sqrt69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(808201));
    }
    static public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long left = 0;
        long right = x + 1;

        while (right - left > 1) {
            long mid = (left + right) / 2;

            if (good(mid, x)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }

    static private boolean good(long mid, int x) {
        return mid * mid <= x;
    }

}
