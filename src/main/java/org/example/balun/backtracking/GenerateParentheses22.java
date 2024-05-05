package org.example.balun.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

     public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        startBruteforce(new StringBuilder(), 0, n, result);
        return result;
    }

     private void startBruteforce(StringBuilder str, int balance, int n, List<String> result) {
        if (balance == 0 && str.length() == n * 2) {
            result.add(str.toString());
            return;
        }
        if (balance < 0 || balance > n * 2 - str.length()) {
            return;
        }

        startBruteforce(str.append("("), balance + 1, n, result);
        str.deleteCharAt(str.length() - 1);

        startBruteforce(str.append(")"), balance - 1, n, result);
        str.deleteCharAt(str.length() - 1);
    }



    static public void generateOk(int n, int balance, StringBuilder currParentheses, List<String> allParentheses) {
        if (balance < 0 || balance > n * 2 - currParentheses.length()) {
            return;
        }

        if (balance == 0 && currParentheses.length() == n * 2) {
            allParentheses.add(currParentheses.toString());
            return;
        }

        currParentheses.append('(');
        generateOk(n, balance + 1, currParentheses, allParentheses);
        currParentheses.deleteCharAt(currParentheses.length() - 1);

        currParentheses.append(')');
        generateOk(n, balance - 1, currParentheses, allParentheses);
        currParentheses.deleteCharAt(currParentheses.length() - 1);
    }

    static public List<String> generateParenthesisOk(int n) {
        List<String> result = new ArrayList<>();
        generateOk(n, 0, new StringBuilder(), result);
        return result;
    }
}
