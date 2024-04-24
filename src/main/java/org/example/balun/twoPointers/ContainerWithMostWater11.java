package org.example.balun.twoPointers;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int diff = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentValue = diff * minHeight;
            if (currentValue > max) {
                max = currentValue;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
