package org.example.cracking_interview.array;

import java.util.HashMap;
import java.util.Map;

public class IsShuffledPalindrome {
    public static void main(String[] args) {
        System.out.println(isShuffledPalindrome("tact coa"));
        System.out.println(isShuffledPalindrome("AAAABBBB"));
        System.out.println(isShuffledPalindrome("a"));
        System.out.println(isShuffledPalindrome(""));

    }

    private static boolean isShuffledPalindrome(String string) {
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            if (aChar == ' ') {
                continue;
            }

            if (map.containsKey(aChar)) {
                Integer integer = map.get(aChar);
                integer++;
                map.put(aChar, integer);
            } else {
                map.put(aChar, 1);
            }
        }

        int oddElementsCounts = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                oddElementsCounts++;
            }
        }

        return oddElementsCounts <= 1;
    }

}
