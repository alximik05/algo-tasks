package org.example.cracking_interview.array;

public class IsRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    private static boolean isRotation(String s1, String s2) {
        String s1s1 = s1 + s1;

//        return isSubstring(s1s1, s2);
        return true;
    }
}
