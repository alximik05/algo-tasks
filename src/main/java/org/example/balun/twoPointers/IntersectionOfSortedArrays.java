package org.example.balun.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 3, 4, 5, 6}, new int[]{3, 3, 5})));
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 3, 4, 5, 6}, new int[]{3, 5})));
    }
    static public int[] intersect(final int[] A, final int[] B) {
        int first = 0;
        int second = 0;

        List<Integer> res = new ArrayList<>();

        while (first < A.length && second < B.length) {
            if (A[first] == B[second]) {
                res.add(A[first]);
                first++;
                second++;
                continue;
            }

            if (A[first] > B[second]) {
                second++;
            } else {
                first++;
            }
        }

        return res.stream().mapToInt(value -> value).toArray();
    }
}
