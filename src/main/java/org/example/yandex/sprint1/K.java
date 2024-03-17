package org.example.yandex.sprint1;

public class K {
    public static void main(String[] args) {
        System.out.println(countOneNumber(5));
        System.out.println(countOneNumber(12));

    }

    static int countOneNumber(int number) {
        int result = 0;
        while (number != 0) {
            int bit = number % 2;
            if (bit == 1) {
                result++;
            }
            number = number / 2;
        }

        return result;
    }
}
