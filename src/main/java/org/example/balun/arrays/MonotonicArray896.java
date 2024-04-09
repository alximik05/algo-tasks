package org.example.balun.arrays;

public class MonotonicArray896 {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
        System.out.println(isMonotonic(new int[]{1,3,2}));
    }

//    Example 1:
//    Input: nums = [1,2,2,3]
//    Output: true

//    Example 2:
//    Input: nums = [6,5,4,4]
//    Output: true

//    Example 3:
//    Input: nums = [1,3,2]
//    Output: false
    static public boolean isMonotonic(int[] nums) {
        int prev = nums[0];

        boolean isAsc = true;
        boolean isDesc = true;

        for (int i = 1; i < nums.length; i++) {
            isAsc = isAsc && (prev <= nums[i]);
            isDesc = isDesc && (prev >= nums[i]);
            prev = nums[i];
        }

        return isAsc || isDesc;
    }
}
