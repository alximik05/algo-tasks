package org.example.balun.arrays;

public class LongestContinuousIncreasingSubsequence674 {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

//    Input: nums = [1,3,5,4,7]
//    Output: 3
//    Input: nums = [2,2,2,2,2]
//    Output: 1
    static public int findLengthOfLCIS(int[] nums) {

        int prev = nums[0];
        int res = 1;

        int currentMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prev < nums[i]) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            res = Math.max(res, currentMax);
            prev = nums[i];
        }
        return res;
    }
}
