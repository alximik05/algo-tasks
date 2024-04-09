package org.example.balun.arrays;

public class MissingNumber268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    static public int missingNumber(int[] nums) {
        int expected = 0;

        for (int i = 0; i <= nums.length; i++) {
            expected += i;
        }

        int fact = 0;

        for (int i = 0; i < nums.length; i++) {
            fact += nums[i];
        }

        return expected - fact;
    }
}
