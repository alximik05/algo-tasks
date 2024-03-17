package org.example.yandex.sprint1;

public class F {
    public static void main(String[] args) {

        System.out.println(hasDuplicates(new int[]{3, 1, 3, 4, 2}));
        System.out.println(hasDuplicates(new int[]{2, 8, 8}));

        System.out.println(hasDuplicates(new int[]{2, 8, 8}));
    }

    static int hasDuplicates(int[] array) {
        boolean[] buffer = new boolean[10_000];

        for (int el : array) {
            if (buffer[el]) {
                return el;
            }
            buffer[el] = true;
        }
        return 0;
    }
}
