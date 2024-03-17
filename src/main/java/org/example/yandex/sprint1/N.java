package org.example.yandex.sprint1;

public class N {
    public static void main(String[] args) {
        System.out.println(powerOf4(15));
        System.out.println(powerOf4(16));

    }

    static boolean powerOf4(int n) {
        // find `log4(n)`
        double i = Math.log(n) / Math.log(4);

        // return true if `log4(n)` is an integer
        return i == Math.floor(i);
    }
}
