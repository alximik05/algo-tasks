package org.example.balun.binarysearch;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange2(new int[]{}, 1)));
    }

    static public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = -1;
        int right = nums.length - 1;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (fun1(nums[mid], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] != target) {
            return new int[]{-1, -1};
        }

        int first = right;
        right = nums.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (fun2(nums[mid], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        int second = left;

        return new int[]{first, second};
    }

    private static boolean fun2(int num, int target) {
        return num <= target;
    }

    private static boolean fun1(int mid, int target) {
        return mid < target;
    }


    static public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = -1;
        int right = nums.length - 1;

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (less(nums[mid], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] != target) {
            return new int[]{-1, -1};
        }

        int first = right;
        right = nums.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (lessEqual(nums[mid], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int second = left;

        return new int[]{first, second};
    }

    static boolean less(int current, int target) {
        return current < target;
    }

    static boolean lessEqual(int current, int target)  {
        return current <= target;
    }
}
