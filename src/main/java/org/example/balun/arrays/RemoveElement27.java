package org.example.balun.arrays;

public class RemoveElement27 {

    public static void main(String[] args) {
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }
    static public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
