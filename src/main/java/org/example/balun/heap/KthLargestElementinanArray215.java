package org.example.balun.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 1));
    }

    static public int findKthLargestQuickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int pivotIndex = left;
            int newPivotIndex = partition(nums, left, right, pivotIndex);
            if (newPivotIndex == nums.length - k) {
                return nums[newPivotIndex];
            } else if (newPivotIndex > nums.length - k) {
                right = newPivotIndex - 1;
            } else {
                left = newPivotIndex + 1;
            }

        }
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        return 0;
    }


    static public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.add(num);
        }

        int counter = 0;
        while (counter < nums.length - k) {
            queue.poll();
            counter++;
        }
        return queue.poll();

    }
    static public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.add(num);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
