package org.example.balun.hash;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                count++;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }
        char[] target = t.toCharArray();
        for (char c : target) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            Integer count = map.get(c);
            count--;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {

        char[] charArray = s.toCharArray();
        int[] counts = new int[26];
        for (char c : charArray) {
            counts[c - 'a'] += 1;
        }
        char[] target = t.toCharArray();
        for (char c : target) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a'] -= 1;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
