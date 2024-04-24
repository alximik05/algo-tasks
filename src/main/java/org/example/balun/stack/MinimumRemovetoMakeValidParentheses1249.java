package org.example.balun.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses1249 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    static public String minRemoveToMakeValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        List<String> result = Arrays.asList(s.split(""));
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else if (charArray[i] == ')') {
                if (stack.isEmpty()) {
                    result.set(i, "");
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            result.set(stack.pop(), "");
        }
        return String.join("", result);
    }

}
