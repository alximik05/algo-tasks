package org.example.yandex.sprint1;

import java.util.Arrays;

public class G {
    public static void main(String[] args) {

        System.out.println(isAnogramma("мошкара", "ромашка"));
        System.out.println(isAnogramma("кошка", "лошка"));

    }

    static boolean isAnogramma(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] charsA = a.toCharArray();
        Arrays.sort(charsA);
        char[] charsB = b.toCharArray();
        Arrays.sort(charsB);

        return Arrays.equals(charsA, charsB);
    }
}
