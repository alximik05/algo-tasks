package org.example.balun.twoPointers;

public class OneEditDistance161 {
    public static void main(String[] args) {
        System.out.println(fun("pale", "palepdgh")); // false
        System.out.println(fun("palesgjd", "pale"));// false
        System.out.println(fun("pale", "bale"));// true
        System.out.println(fun("pale", "bake"));// false
    }

    static boolean fun(String s1, String s2) {
        if (s1.equals(s2)) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        if (chars1.length == chars2.length) {
            return isOneReplace(chars1, chars2);
        }

        if (chars1.length - 1 == chars2.length) {
            return isOneChange(chars1, chars2);
        }

        if (chars1.length + 1 == chars2.length) {
            return isOneChange(chars2, chars1);
        }

        return false;
    }

    private static boolean isOneChange(char[] chars1, char[] chars2) {
        int first = 0;
        int second = 0;

        while (first < chars1.length && second < chars2.length) {
            if (chars1[first] != chars2[second]) {
                if (first != second) {
                    return false;
                } else {
                    first++;
                }
            } else {
                first++;
                second++;
            }
        }
        return true;
    }

    static boolean isOneReplace(char[] chars1, char[] chars2) {
        boolean replaced = false;

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                if (replaced) {
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }
}
