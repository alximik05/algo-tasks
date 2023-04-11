package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSum4(
                new int[]{10, 2, 4, 1, 4, -5, 7, 8, 11, 7}, 14))); // 0 2

        System.out.println(Arrays.toString(findSum4(
                new int[]{3, 2, 4}, 6))); // 1 2

        System.out.println(Arrays.toString(findSum4(
                new int[]{3, 3}, 6)));  // 0 1
        System.out.println(Arrays.toString(findSum4(
                new int[]{2,7,11,15}, 9))); // 0 1

    }


    // for values only - not for indices
    private static int[] findSum4(int[] nums, int target) {

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    private static int[] findSum3(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var secondNumber = target - nums[i];
            if (numbers.containsKey(secondNumber)) {
                return new int[]{i, numbers.get(secondNumber)};
            }
            numbers.put(nums[i], i);
        }
        return new int[]{};
    }

//    private static int[] findSum1(int[] nums, int target) {
//        Map<Integer, Integer> numbers = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            numbers.put(nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            var secondNumber = target - nums[i];
//            if (numbers.containsKey(secondNumber) && numbers.get(secondNumber) != i) {
//                return new int[]{numbers.get(nums[i]), numbers.get(secondNumber)};
//            }
//        }
//        return new int[]{};
//    }
//
//
//    private static int[] findSum2(int[] nums, int target) {
//        Map<Integer, List<Integer>> numbers = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (numbers.containsKey(nums[i])) {
//                numbers.get(nums[i]).add(i);
//            } else {
//                numbers.put(nums[i], new ArrayList<>(List.of(i)));
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            var secondNumber = target - nums[i];
//            if (numbers.containsKey(secondNumber)) {
//                List<Integer> indices = numbers.get(secondNumber);
//                if (indices.size() == 1) {
//                    return new int[]{i, numbers.get(secondNumber).get(0)};
//                } else {
//                    if (indices.get(0) == i) {
//                        return new int[]{i, indices.get(1)};
//                    } else {
//                        return new int[]{i, indices.get(0)};
//                    }
//                }
//            }
//        }
//        return new int[]{};
//    }
}
