package org.example.balun.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {


//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
     static public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> map = new HashMap<>();
         for (String s : strs) {
             char[] counts = new char[26];
             for (char c : s.toCharArray()) {
                 counts[c - 'a']++;
             }
             String keyString = String.valueOf(counts);
             if (!map.containsKey(keyString)) {
                 map.put(keyString, new ArrayList<>());
             }
             map.get(keyString).add(s);
         }
         return new ArrayList<>(map.values());
    }
}
