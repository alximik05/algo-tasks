package org.example.yandex.sprint1;

import java.util.Arrays;

public class B {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxKStudents(new int[]{1, 2, 3, 1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(maxKStudents(new int[]{5,5,5,5,5,5,4,4,4,4,1, 1,1,  2, 2, 5}, 3)));
    }

    private static int[] maxKStudents(int[] ints, int k) {
        int[] xz = new int[10_000];

        for (int anInt : ints) {
            xz[anInt]++;
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            int maxValue = 0;
            for (int j = 0; j < xz.length; j++) {
                if (xz[j] > maxValue) {
                    maxIndex = j;
                    maxValue = xz[j];
                }
            }
            result[i] = maxIndex;
            xz[maxIndex] = -1;
        }
        return result;
    }


    private static int[] maxKStudents2(int[] ints, int k) {

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int maxValue = -1;
            for (int j = 0; j < ints.length; j++) {


            }

        }
        return result;
    }
}
