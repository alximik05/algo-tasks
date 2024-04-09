package org.example.balun.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {

//    A = [      [0, 30]
//            [5, 10]
//            [15, 20]
//            ]
//    2

//    A =  [     [1, 18]
//            [18, 23]
//            [15, 29]
//            [4, 15]
//            [2, 11]
//            [5, 13]
//            ]

//    4

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(solve(new int[][]{{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}}));
    }

    static public int solve(int[][] A) {
        List<int[]> tmp = new ArrayList<>();

        for (int[] ints : A) {
            int begin = ints[0];
            int end = ints[1];

            tmp.add(new int[]{begin, 1});
            tmp.add(new int[]{end, -1});
        }

        tmp.sort((o1, o2) -> o1[0] - o2[0]);

        int max = 0;
        int current = 0;

        for (int[] ints : tmp) {
            current = current + ints[1];
            max = Math.max(current, max);
        }
        return max;
    }
}
