package org.example.balun.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber17 {

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        result.forEach(System.out::println);
    }


    static public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Character, String> buttons = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        List<String> result = new ArrayList<>();
        startBruteForce(0, new StringBuilder(), buttons, digits, result);
        return result;
    }

    static private void startBruteForce(int currentIndex, StringBuilder stringBuilder, Map<Character, String> buttons, String digits, List<String> result) {
        if (currentIndex == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        char currentDigit = digits.charAt(currentIndex);
        char[] charInNumber = buttons.get(currentDigit).toCharArray();
        for (char c : charInNumber) {
            stringBuilder.append(c);
            startBruteForce(currentIndex + 1, stringBuilder, buttons, digits, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
