package org.example.balun.arrays;

public class ConsecutiveCharacters1446 {

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));

    }
    static public int maxPower(String s) {
        char[] charArray = s.toCharArray();

        int maxRes = 1;

        int currentMax = 1;

        char prev = charArray[0];

        for (int i = 1; i < charArray.length; i++) {
            if (prev == charArray[i]) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            prev = charArray[i];
            maxRes = Math.max(maxRes, currentMax);
        }
        return maxRes;
    }
}
