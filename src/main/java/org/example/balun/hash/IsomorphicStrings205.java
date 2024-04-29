package org.example.balun.hash;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("foo", "bar"));
    }

    static public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sourceToTarget = new HashMap<>();
        Map<Character, Character> targetToSource = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sourceToTarget.containsKey(s.charAt(i)) && sourceToTarget.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (targetToSource.containsKey(t.charAt(i)) && targetToSource.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            sourceToTarget.put(s.charAt(i), t.charAt(i));
            targetToSource.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
