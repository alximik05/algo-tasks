package org.example.balun.binarysearch;

public class PeakIndexinaMountainArray852 {
    public static void main(String[] args) {

        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 5, 2}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (fun(arr[mid - 1], arr[mid])) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

     static boolean fun(int prev, int target) {
        return prev < target;
    }

}
