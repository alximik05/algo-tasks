package org.example.yandex.sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree")); // eert
        System.out.println(frequencySort("ztwidhfk")); // dfhiktwz

    }

    static String frequencySort(String source) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : source.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(charFrequency.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedList) {
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
