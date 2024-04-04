package org.example.balun.arrays;

public class ReverseInt {
    public static void main(String[] args) {
        int number = 100;

        int res = 0;

        while (number != 0) {
            int a = number % 10;
            res = res * 10 + a;
            number = number / 10;
        }
        System.out.println(res);
    }
}

