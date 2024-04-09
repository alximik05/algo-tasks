package org.example.balun.stack;

import java.util.Stack;

public class BaseballGame682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
    static public int calPoints(String[] operations) {
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                String last = strings.pop();
                String prevLast = strings.pop();
                int lastInt = Integer.parseInt(last);
                int prevLastInt = Integer.parseInt(prevLast);
                int newScore = lastInt + prevLastInt;
                strings.push(String.valueOf(prevLastInt));
                strings.push(String.valueOf(lastInt));
                strings.push(String.valueOf(newScore));
            } else if (operations[i].equals("D")) {
                String last = strings.pop();
                int lastInt = Integer.parseInt(last);
                int newScore = lastInt * 2;
                strings.push(last);
                strings.push(String.valueOf(newScore));
            } else if (operations[i].equals("C")) {
                strings.pop();
            } else {
                strings.push(operations[i]);
            }
        }
        return strings.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
