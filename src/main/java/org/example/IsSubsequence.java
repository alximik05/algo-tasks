package org.example;

public class IsSubsequence {
    public static void main(String[] args) {

        System.out.println(isSubsequence(new int[]{1, 6, -1, 10},
                                        new int[]{5, 1, 22, 25, 6, -1, 8, 10})); // true


        System.out.println(isSubsequence(new int[]{1, 6, -1, 10, 1},
                new int[]{5, 1, 22, 25, 6, -1, 8, 10})); // false

    }


    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }


        var indexSub = 0;
        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(indexSub)) {
                indexSub++;
            }
            if(indexSub == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSubsequence(int[] sub, int[] target) {
        if (sub.length > target.length) {
            return false;
        }

        int indexSub = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == sub[indexSub]) {
                indexSub++;
            }
            if (indexSub == sub.length) {
                return true;
            }
        }
        return false;
    }
}
