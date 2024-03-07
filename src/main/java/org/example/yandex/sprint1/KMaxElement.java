package org.example.yandex.sprint1;

import java.util.Arrays;

public class KMaxElement {

    public static void main(String[] args) {

        //k*n
        var array =  kMaxElement(new int[]{4, 2, 3, 0, 8, 6, 7, 3, 9, 9}, 4);

        System.out.println(Arrays.toString(array));
    }


    static int[] kMaxElement(int [] array, int k) {

        for (int i = 0; i < k; i++) {
            for (int j = i; j < array.length; j++) {

                if(array[j] > array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return Arrays.copyOfRange(array, 0, k);

    }
}
