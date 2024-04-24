package org.example.balun.twoPointers;

import java.util.Arrays;

public class MergeSortedArray88 {

    // Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // Output: [1,2,2,3,5,6]

//    Input: nums1 = [1], m = 1, nums2 = [], n = 0
//    Output: [1]

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        merge(nums1, 3, new int[]{2, 5, 6}, 3);
//        System.out.println(Arrays.toString(nums1));


//        int[] nums2 = {1};
//        merge(nums2, 1, new int[]{}, 0);
//        System.out.println(Arrays.toString(nums2));
    }

    static public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int longer = m - 1;
        int shorter = n - 1;

        int last = nums1.length - 1;

        while (shorter >= 0) {
            if (longer >= 0 && nums1[longer] > nums2[shorter]) {
                nums1[last] = nums1[longer];
                longer--;
            } else {
                nums1[last] = nums2[shorter];
                shorter--;
            }
            last--;
        }
    }

    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=nums1.length-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}
