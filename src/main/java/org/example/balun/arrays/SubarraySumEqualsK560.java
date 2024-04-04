package org.example.balun.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {

//    Example 1:
//    Input: nums = [1,1,1], k = 2
//    Output: 2

//    Example 2:
//    Input: nums = [1,2,3], k = 3
//    Output: 2

    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }
    static public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int result = 0;
        int currentPx = 0;
        for (int num : nums) {
            currentPx = currentPx + num;

            if (map.containsKey(currentPx - k)) {
                result += map.get(currentPx - k);
            }

            if (map.containsKey(currentPx)) {
                Integer i = map.get(currentPx);
                i++;
                map.put(currentPx, i);
            } else {
                map.put(currentPx, 1);
            }
        }
        return result;
    }
}
