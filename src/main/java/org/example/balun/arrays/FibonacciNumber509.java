package org.example.balun.arrays;

public class FibonacciNumber509 {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }
    static public int fib(int n) {


        int prevprev = 0;
        int prev = 1;

        int cur = 0;
        for (int i = 1; i < n; i++) {
            cur = prev + prevprev;
            prevprev = prev;
            prev = cur;
        }
        return cur;
    }
}


// 0 1 => 1 => 2 => 3
