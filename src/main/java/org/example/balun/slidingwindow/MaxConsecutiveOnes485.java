package org.example.balun.slidingwindow;

public class MaxConsecutiveOnes485 {

     public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int result = 0;

        while (left < nums.length) {
            if (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                right++;
            } else {
                if (nums[right] == 1) {
                    result = Math.max(result, right - left + 1);
                }
                right++;
                left = right;
            }
        }
        return result;
    }

}
