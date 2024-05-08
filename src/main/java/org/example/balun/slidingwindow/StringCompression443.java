package org.example.balun.slidingwindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCompression443 {

//    Input: chars = ['a','a','b','b','c','c','c']
//    Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
    public static void main(String[] args) {
        char[] source = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(source));
        System.out.println(Arrays.toString(source));
    }
    static public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        List<Character> result = new ArrayList<>();

        while (left < chars.length) {
            if (right + 1 < chars.length && chars[right] == chars[right + 1]) {
                right++;
            } else {
                result.add(chars[left]);
                if (right - left + 1 > 1) {
                    int dist = right - left + 1;
                    String[] split = String.valueOf(dist).split("");
                    for (String s : split) {
                        result.add(s.toCharArray()[0]);
                    }
                }
                right++;
                left = right;
            }

        }
        for (int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i);
        }

        return result.size();
    }
}
