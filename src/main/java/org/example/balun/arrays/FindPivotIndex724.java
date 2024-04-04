package org.example.balun.arrays;

public class FindPivotIndex724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

//    Input: nums = [1,7,3,6,5,6]
//    Output: 3
    static public int pivotIndex(int[] nums) {
        int allSum = 0;
        for (int num : nums) {
            allSum += num;
        }

        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (allSum - prev - num == prev) {
                return i;
            }
            prev += num;
        }
        return -1;
    }
}
