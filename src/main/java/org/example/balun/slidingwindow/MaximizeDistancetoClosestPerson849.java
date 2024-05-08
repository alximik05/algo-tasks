package org.example.balun.slidingwindow;

public class MaximizeDistancetoClosestPerson849 {

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
    }
    static public int maxDistToClosest(int[] seats) {
        int left = 0;
        int right = 0;
        int result = 0;

        while (left < seats.length) {
            if (right + 1 < seats.length && seats[right] == seats[right + 1]) {
                right++;
                continue;
            } else {
                if (seats[right] == 0) {
                    if (left == 0 || right == seats.length - 1) {
                        result = Math.max(result, (right - left + 1));
                    } else {
                        result = Math.max(result, (right - left + 2) / 2);
                    }
                }
            }
            right++;
            left = right;
        }
        return result;
    }
}
