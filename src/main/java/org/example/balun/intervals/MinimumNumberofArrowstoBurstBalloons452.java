package org.example.balun.intervals;

import java.util.Arrays;


public class MinimumNumberofArrowstoBurstBalloons452 {
    public static void main(String[] args) {
//        Input: points = [[10,16],[2,8],[1,6],[7,12]]
//        Output: 2
//        Input: points = [[1,2],[3,4],[5,6],[7,8]]
//        Output: 4
//        Input: points = [[1,2],[2,3],[3,4],[4,5]]
//        Output: 2
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
    static public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);

        int strikes = 1;
        int[] prev = points[0];
        for (int[] point : points) {
            if (hasOverlap(prev, point)) {
                prev = intersection(prev, point);
            } else {
                strikes++;
                prev = point;
            }
        }
        return strikes;
    }

    static boolean hasOverlap(int[] prev, int[] current) {
        return Math.max(prev[0], current[0]) <= Math.min(prev[1], current[1]);
    }

    static int[] intersection(int[] prev, int[] current) {
        return new int[]{Math.max(prev[0], current[0]), Math.min(prev[1], current[1])};
    }
}
