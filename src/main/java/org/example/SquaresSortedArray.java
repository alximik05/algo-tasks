package org.example;

import java.util.Arrays;

public class SquaresSortedArray {


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortedSquares1(new int[]{-4, -1, 0, 3, 4, 10}))); // [0,1,9,16,16,100]
//
//        System.out.println(Arrays.toString(sortedSquares1(new int[]{-7, -3, 2, 3, 11}))); // [4,9,9,49,121]
//
//        System.out.println(Arrays.toString(sortedSquares1(new int[]{10, 10, 10, 10})));
//
//        System.out.println(Arrays.toString(sortedSquares1(new int[]{1, 1, 1, 1 ,2})));
//
//        System.out.println(Arrays.toString(sortedSquares1(new int[]{-5, 0, 5})));
//
//        System.out.println(Arrays.toString(sortedSquares1(new int[]{-9, -1})));
        System.out.println(Arrays.toString(sortedSquares1(new int[]{-7,-3,2,3,11})));


    }

    public static int[] sortedSquares1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;

            }
            index--;
        }
        return result;
    }



    public static int[] sortedSquares(int[] nums) {

            // find maximum value in array
        int max = nums[0] < 0 ? -nums[0] : nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] temporal = new int[max+1];
        int tmpValue = 0;
        for (int i = 0; i < nums.length; i++) {
            tmpValue = nums[i];
            if (tmpValue < 0) {
                tmpValue = -tmpValue;
            }
            temporal[tmpValue] = temporal[tmpValue] + 1;
        }

        int[] result = new int[nums.length];


        int tmpIndex = 0;
        for (int i = 0; i < temporal.length; i++) {
            if (temporal[i] != 0) {
                int border = temporal[i];
                int tmpSquare = i * i;
                for (int j = border; j > 0; j--) {
                    result[tmpIndex] = tmpSquare;
                    tmpIndex++;
                }
            }
        }
        return result;
    }
}
