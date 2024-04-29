package org.example.balun.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
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
