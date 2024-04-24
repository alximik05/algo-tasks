package org.example.balun.stack;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    static public boolean isValid(String s) {

        Stack<Character> strings = new Stack<>();
        

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(') {
                strings.push(')');
            } else if (c == '{') {
                strings.push('}');
            } else if (c == '[') {
                strings.push(']');
            } else if (strings.isEmpty() || strings.pop() != c) {
                return false;
            }
        }
        return strings.isEmpty();
    }

    static public boolean isValid2(String s) {
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> brackMap = Map.of(
                '[', ']',
                '{', '}',
                '(', ')'
        );

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (brackMap.containsKey(c)) {
                brackets.push(c);
                continue;
            }

            if (brackets.isEmpty()) {
                return false;
            }
            Character last = brackets.pop();
            if (brackMap.get(last) != c) {
                return false;
            }
        }
        return brackets.isEmpty();
    }
}


