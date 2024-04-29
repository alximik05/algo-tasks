package org.example.balun.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> first = new HashMap<>();
        for (int number : nums1) {
            if (first.containsKey(number)) {
                Integer count = first.get(number);
                count++;
                first.put(number, count);
            } else {
                first.put(number, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int number : nums2) {
            if (first.containsKey(number) && first.get(number) != 0) {
                result.add(number);
                Integer count = first.get(number);
                count--;
                first.put(number, count);
            }
        }
        return result.stream().mapToInt(value -> value).toArray();
    }
}
