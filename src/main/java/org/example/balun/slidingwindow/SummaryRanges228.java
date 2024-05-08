package org.example.balun.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

    public static void main(String[] args) {
        summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).stream().forEach(System.out::println);
    }

    static public List<String> summaryRanges(int[] nums) {
        int left = 0;
        int right = 0;
        List<String> result = new ArrayList<>();
        while (left < nums.length) {
            if (right + 1 < nums.length && nums[right] + 1 == nums[right + 1]) {
                right++;
            } else {
                if (left == right) {
                    result.add(String.valueOf(nums[left]));
                } else {
                    result.add(nums[left] + "->" + nums[right]);
                }
                right++;
                left = right;
            }
        }
        return result;
    }
}
