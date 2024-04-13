package org.example.balun.binarysearch;

public class ValidPerfectSquare367 {

    public boolean isPerfectSquare(int num) {

        long left = 1;
        long right = num + 1;

        while (right - left > 1) {
            long mid = (left + right) / 2;

            if (good1(mid, num)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return ((num / left) == left) && ((num % left) == 0);

    }

    private boolean good1(long mid, long num) {
        return mid * mid <= num;
    }
}
