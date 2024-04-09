package org.example.balun.stack;

import java.util.List;
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
}
