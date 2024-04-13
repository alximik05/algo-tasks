package org.example.balun.binarysearch;

public class SearchinRotatedSortedArray33 {
    public static void main(String[] args) {

//        Example 1:
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4

//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1

//        Example 3:
//        Input: nums = [1], target = 0
//        Output: -1
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 0));
        System.out.println(search(new int[]{1, 3, 5}, 3));
        System.out.println(search(new int[]{1, 3 }, 3));
    }

    static public int search(int[] nums, int target) {

        int left = -1;
        int right = nums.length -1;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (lessThanLast(nums[mid], nums[nums.length - 1])) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int offset = right;
        left = 0;
        right = nums.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (isTarget(nums[(mid + offset) % nums.length], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        left = (left + offset) % nums.length;

        if (nums[left] == target) {
            return left;
        } else return -1;
    }

    static boolean isTarget(int cur, int target) {
        return cur <= target;
    }

    static boolean lessThanLast(int cur, int last) {
        return cur > last;
    }
}

