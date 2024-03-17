package org.example.yandex.sprint1;

public class J {
    public static void main(String[] args) {

        System.out.println(findSingle(new int[]{0, 4, 1, 0, 2, 1, 2}));
        System.out.println(findSingle(new int[]{42, 67, 67, 42, 42}));

    }

    static int findSingle(int[] array) {
        int[] buffer = new int[10_000];

        for (int el : array) {
            buffer[el]++;
        }

        for (int i = 0; i < buffer.length; i++) {

            if (buffer[i] % 2 != 0) {
                return i;
            }
        }
        return -1;
    }
}
