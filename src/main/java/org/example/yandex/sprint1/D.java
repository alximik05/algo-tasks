package org.example.yandex.sprint1;

import java.util.Arrays;

public class D {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(resetZeros2(new int[]{-1, 0, 0, 1, 2, -1, -4, 0})));
        System.out.println(Arrays.toString(resetZeros2(new int[]{-1, 1, 2, -1, -4})));
        System.out.println(Arrays.toString(resetZeros2(new int[]{0, 0, 2, -1, -4})));

    }


    static int[] resetZeros2(int[] scores) {
        int lastNotZeroIndex = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != 0) {
                scores[lastNotZeroIndex] = scores[i];
                lastNotZeroIndex++;
            }
        }
        return Arrays.copyOfRange(scores, 0, lastNotZeroIndex);
    }


    static int[] resetZeros(int[] scores) {
        int resultSize = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != 0) {
                resultSize++;
            }
        }
        int[] result = new int[resultSize];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != 0) {
                result[index] = scores[i];
                index++;
            }
        }

        return result;

    }
}
