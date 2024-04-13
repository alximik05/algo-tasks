package org.example.balun.binarysearch;

public class BinarySearch704 {

    public static void main(String[] args) {
//        Input: nums = [-1,0,3,5,9,12], target = 9
//        Output: 4

//        Input: nums = [-1,0,3,5,9,12], target = 2
//        Output: -1

        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    static public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (fun(nums[mid], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;

    }

    static boolean fun(int current, int target) {
        return current <= target;
    }


//    static public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left <= right) {
//            int mid = (right + left) / 2;
//            if (target == nums[mid]) {
//                return mid;
//            }
//            if (nums[mid] <= target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }


}
