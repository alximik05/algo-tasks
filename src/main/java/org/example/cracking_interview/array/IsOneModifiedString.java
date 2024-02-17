package org.example.cracking_interview.array;

import java.util.HashMap;
import java.util.Map;

public class IsOneModifiedString {
    public static void main(String[] args) {
        System.out.println(isOneModifiedString2("pale", "palepdgh")); // false
        System.out.println(isOneModifiedString2("palesgjd", "pale"));// false
        System.out.println(isOneModifiedString2("pale", "bale"));// true
        System.out.println(isOneModifiedString2("pale", "bake"));// false
    }

    static boolean isOneModifiedString2(String source, String target) {
        if (source.equals(target)) {
            return true;
        }
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        if (sourceArray.length == targetArray.length) {
            return isOnlyOneReplace(sourceArray, targetArray);
        }
        if (sourceArray.length - 1 == targetArray.length) {
            return isOnlyOneEdit(sourceArray, targetArray);
        } else if (sourceArray.length + 1 == targetArray.length) {
            return isOnlyOneEdit(targetArray, sourceArray);
        }

        return false;
    }

    private static boolean isOnlyOneReplace(char[] sourceArray, char[] targetArray) {
        boolean alreadyFoundDiff = false;
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] != targetArray[i]) {
                if (alreadyFoundDiff) {
                    return false;
                }
                alreadyFoundDiff = true;
            }
        }
        return true;
    }

    private static boolean isOnlyOneEdit(char[] sourceArray, char[] targetArray) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < sourceArray.length && index2 < targetArray.length) {
            if (sourceArray[index1] != targetArray[index2]) {
                if (index1 != index2) {
                    return false;
                } else {
                    index1++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
