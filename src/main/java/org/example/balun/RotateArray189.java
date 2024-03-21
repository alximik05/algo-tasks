package org.example.balun;

import java.util.Arrays;

public class RotateArray189 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 2)));

//{1, 2, 3, 4, 5,| 6, 7}

//{5, 4, 3, 2, 1 | 6, 7}
//{5, 4, 3, 2, 1 | 7, 6}

//{5, 4, 3, 2, 1, 7, 6}
//{6, 4, 3, 2, 1, 7, 5}
//{6, 7, 3, 2, 1, 4, 5}
//{6, 7, 1, 2, 3, 4, 5}



    }



    static public int[] rotate2(int[] nums, int k) {


        int length = nums.length - 1;
        mirror(nums, 0, length - k);
        mirror(nums, length - k + 1, length);
        mirror(nums, 0, length);
        return nums;

    }

    static void mirror(int[] array, int begin, int end) {
        while (begin < end) {
            int tmp = array[begin];
            array[begin] = array[end];
            array[end] = tmp;
            begin++;
            end--;
        }
    }




    static public int[] rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return arr;
    }
}
