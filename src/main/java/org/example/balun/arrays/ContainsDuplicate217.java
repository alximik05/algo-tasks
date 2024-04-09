package org.example.balun.arrays;

import java.util.Arrays;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().count();
    }
}
