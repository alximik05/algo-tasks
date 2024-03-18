package org.example.yandex.sprint1;

import java.util.Arrays;

public class O {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeAndSort(new int[]{1,2,3,0,0,0}, new int[]{2,5,6})));
    }

    static int[] mergeAndSort(int[] first, int[] second) {
        int zeroIndex = 0;
        for (int j = 0; j < first.length; j++) {
            if (first[j] == 0) {
                zeroIndex = j;
                break;
            }
        }

        for (int i = 0; i < second.length; i++) {
            first[zeroIndex] = second[i];
            zeroIndex++;
        }

        Arrays.sort(first);

        return first;
    }
}
