package org.example.balun.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements347 {

    //    Example 1:
//
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]
//    Example 2:
//
//    Input: nums = [1], k = 1
//    Output: [1]
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }

    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                count++;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            queue.add(integerIntegerEntry);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }



    static public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                count++;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer>[] counts = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (counts[pair.getValue()] != null) {
                List<Integer> numbersWithCurrentCount = counts[pair.getValue()];
                numbersWithCurrentCount.add(pair.getKey());
            } else {
                List<Integer> element = new ArrayList<>();
                element.add(pair.getKey());
                counts[pair.getValue()] = element;
            }
        }


        List<Integer> result = new ArrayList<>();
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] != null && k > 0) {
                for (Integer number : counts[i]) {
                    if (k <= 0) {
                        break;
                    }
                    result.add(number);
                    k--;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
