package org.example.balun.sorting;

import java.util.Arrays;

public class SortanArray912 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(sortArray(new int[]{5, 1, 1, 2, 0, 0})));

    }
    static public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
}
