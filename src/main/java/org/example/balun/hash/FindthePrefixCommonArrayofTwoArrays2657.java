package org.example.balun.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindthePrefixCommonArrayofTwoArrays2657 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
    }

    static public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int numberA = 0;
        int numberB = 0;


        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            numberA = numberA | 1 << A[i];
            numberB = numberB | 1 << B[i];

            int counter = 0;

            int sum = numberA & numberB;

            while (sum != 0) {
                counter += sum % 2;
                sum /= 2;
            }
            result[i] = counter;
        }
        return result;
    }

    static public int[] findThePrefixCommonArray2(int[] A, int[] B) {
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        int counter = 0;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                counter++;
            }
            if (bSet.contains(A[i])) {
                counter++;
            }
            if (aSet.contains(B[i])) {
                counter++;
            }

            aSet.add(A[i]);
            bSet.add(B[i]);
            result[i] = counter;
        }
        return result;
    }

}
