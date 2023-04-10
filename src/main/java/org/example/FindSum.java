package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSum {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findSum(
//                new int[]{10, 2, 4, 1, 4, -5, 7, 8, 11, 7}, 14)));

//        System.out.println(Arrays.toString(findSum1(
//                new int[]{3, 2, 4}, 6)));

        System.out.println(Arrays.toString(findSum3(
                new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(findSum3(
                new int[]{2,7,11,15}, 9)));

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
