package org.example.cracking_interview.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUniqueCharset {
    public static void main(String[] args) {
        System.out.println(isUniqueWithoutSet("QWERTYUIOPASDFGHJKL"));
        System.out.println(isUniqueWithoutSet("QWERTYUIOPASDFGHJKLQ"));

    }

    static boolean isUnique(String string) {
        Set<Character> set = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }

    static boolean isUniquePointers(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static boolean isUniqueWithoutSet(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }

            }
        }
        return true;
    }


    static boolean isUniqueByStream(String str) {
        return str.length() == str.chars().distinct().count();
    }
}
