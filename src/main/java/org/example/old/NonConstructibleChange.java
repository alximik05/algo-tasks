package org.example.old;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {

//        System.out.println(solution(new int[]{5, 7, 1, 1, 2, 3,22})); // 20
        System.out.println(solution(new int[]{1, 2 ,5})); // 4
//        System.out.println(solution(new int[]{6})); // 1

    }

    private static int solution(int[] moneyArray) {
        Arrays.sort(moneyArray);

        int current = 0;
        for (int i = 0; i < moneyArray.length; i++) {
            if (moneyArray[i] > current + 1) {
                return current + 1;
            }
            current = current + moneyArray[i];
        }
        return current + 1;
    }
}
