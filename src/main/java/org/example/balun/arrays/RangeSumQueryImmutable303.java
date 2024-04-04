package org.example.balun.arrays;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumQueryImmutable303 {

    public static void main(String[] args) {
        NumArray x = new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(x.px);

        System.out.println(x.sumRange(0, 2));
        System.out.println(x.sumRange(2, 5));
        System.out.println(x.sumRange(0, 5));
    }
     static class NumArray {
        List<Integer> px = new ArrayList<>();

        public NumArray(int[] nums) {

            px.add(0);
            for (int num : nums) {
                px.add(px.get(px.size() - 1) + num);
            }

        }

        public int sumRange(int left, int right) {
            return px.get(right + 1) - px.get(left);
        }

    }
}
