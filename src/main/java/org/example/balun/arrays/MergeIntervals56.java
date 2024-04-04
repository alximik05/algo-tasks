package org.example.balun.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals56 {
    //    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    //    Output:            [[1,6],[8,10],[15,18]]

//    [[1,4],[2,3]]

    // 12345 54321 int
public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
        return intervals;
    }

    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

    List<int[]> result = new LinkedList<>();

    int[] prev = intervals[0];
    for (int i = 0; i < intervals.length; i++) {
        if (isOverlay(prev, intervals[i])) {
            prev = merge(prev, intervals[i]);
        } else {
            result.add(prev);
            prev = intervals[i];
        }
    }
    result.add(prev);
    return result.toArray(new int[][]{});
}

    public boolean isOverlay(int[] a, int[] b) {
        return a[1] >= b[0];
    }

    public int[] merge(int[] a, int[] b) {
        int left = Math.min(a[0], b[0]);
        int right = Math.max(a[1], b[1]);
        return new int[]{left, right};
    }
}
