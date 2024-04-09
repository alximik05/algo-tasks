package org.example.balun.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCompression443 {

//    Input: chars = ['a','a','b','b','c','c','c']
//    Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
    public static void main(String[] args) {
        char[] source = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compress(source);
        System.out.println(Arrays.toString(source));
    }
    static public int compress(char[] chars) {

        int res = 0;
        int count = 0;
        char previous = chars[0];
        for (int i = 1; i < chars.length; i++) {
            while (previous == chars[i]) {
                count++;
                previous = chars[i];
                continue;
            }



        }
        return 0;
    }
}
