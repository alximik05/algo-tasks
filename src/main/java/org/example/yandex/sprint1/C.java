package org.example.yandex.sprint1;

import java.util.Arrays;

public class C {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(govno2(4, new int[]{1, 2, 0, 0}, 34)));
        System.out.println(Arrays.toString(govno2(2, new int[]{9, 5}, 17)));
    }

    private static int[] govno2(int length, int[] ints, int k) {

        int fromArray = arrayToInt(ints);
        int resultAsInt = fromArray + k;
        return intToArray(resultAsInt);
    }


    static int[] intToArray(int number) {
        int razryad = (int) Math.log10(number) + 1;
        int[] result = new int[razryad];
        for (int i = razryad - 1; i >= 0; i--) {
            result[i] = number % 10;
            number = number / 10;
        }

        return result;
    }

    static int arrayToInt(int[] ints) {
        int result = 0;
        for (int i = 0; i < ints.length; i++) {
            result = result * 10 + ints[i];
        }
        return result;
    }
}
