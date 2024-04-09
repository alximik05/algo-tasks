package org.example.balun.arrays;

import java.util.Arrays;

public class ShuffletheArray1470 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    static public int[] shuffle(int[] nums, int n) {

        int[] res = new int[nums.length];

        int left = 0;

        int right = n;

        int index = 0;
        while (left < n) {
            res[index] = nums[left];
            index++;
            res[index] = nums[right];
            index++;
            left++;
            right++;
        }
        return res;
    }
}
