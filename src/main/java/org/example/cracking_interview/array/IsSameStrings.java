package org.example.cracking_interview.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IsSameStrings {
    public static void main(String[] args) {
        System.out.println(isSameStrings2("abcde", "edcba"));
        System.out.println(isSameStrings2("abcde", "edcaa"));

    }

    static boolean isSameStrings(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        Arrays.sort(charsA);
        Arrays.sort(charsB);


        String s = new String(charsA);
        String s1 = new String(charsB);

        return s.equals(s1);
    }

    static boolean isSameStrings2(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        Map<Character, Integer> map = getCharacterIntegerMap(charsA);

        for (int i = 0; i < charsB.length; i++) {
            if (!map.containsKey(charsB[i])) {
                return false;
            } else {
                Integer value = map.get(charsB[i]);
                value--;
                if (value < 0) {
                    return false;
                }
                map.put(charsB[i], value);
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharacterIntegerMap(char[] charsA) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charsA.length; i++) {
            if (map.containsKey(charsA[i])) {
                Integer value = map.get(charsA[i]);
                value++;
                map.put(charsA[i], value);
            } else {
                map.put(charsA[i], 1);
            }
        }
        return map;
    }
}
