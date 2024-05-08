package org.example.balun.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int left = 0;
        int right = 0;
        int max = 1;
        while (left < s.length()) {
            if (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            } else {
                max = Math.max(max, right - left + 1);
                set.remove(s.charAt(left));
                left++;

                if (right < left && left < s.length()) {
                    right = left;
                    set.clear();
                    set.add(s.charAt(right));
                }
            }

        }
        return max;
    }
}
