package org.example.balun.arrays;

public class RemoveDuplicatesfromSortedArray26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2})); // 2
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})); // 5
    }

    static public int removeDuplicates(int[] nums) {

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
