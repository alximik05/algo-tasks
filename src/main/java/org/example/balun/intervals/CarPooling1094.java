package org.example.balun.intervals;

import java.util.ArrayList;
import java.util.List;

public class CarPooling1094 {

//    Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//    Output: false
//
//    Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//    Output: true
    public static void main(String[] args) {
//        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
//        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        // [[4,5,6],[6,4,7],[4,3,5],[2,3,5]]
        System.out.println(carPooling(new int[][]{{4, 5, 6}, {6, 4, 7}, {4, 3, 5}, {2, 3, 5}}, 13));

    }
    static public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> tmp = new ArrayList<>();

        for (int[] trip : trips) {
            int begin = trip[1];
            int end = trip[2];
            int amount = trip[0];
            tmp.add(new int[]{begin, amount});
            tmp.add(new int[]{end, -amount});
        }

        tmp.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int current = 0;
        for (int[] ints : tmp) {
            current = current + ints[1];
            if (current > capacity) {
                return false;
            }
        }
        return true;
    }
}
