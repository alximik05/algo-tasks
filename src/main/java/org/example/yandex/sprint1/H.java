package org.example.yandex.sprint1;

import java.util.Arrays;

public class H {
    public static void main(String[] args) {

        System.out.println(isPolindrom("abccba"));
        System.out.println(isPolindrom("abcDcba"));

    }

    static boolean isPolindrom(String a) {
        char[] chars = a.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
