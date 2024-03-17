package org.example.yandex.sprint1;

public class E {
    public static void main(String[] args) {
        System.out.println(intToBinary(5));
        System.out.println(intToBinary(14));
    }

    static int intToBinary(int num) {
        int result = 0;
        int multiplier = 1;
        while (num != 0) {
            int bit = num % 2;
            result = bit * multiplier + result;
            num = num / 2;
            multiplier = multiplier * 10;
        }
        return result;
    }
}
