package org.example.balun.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

    public static void main(String[] args) {
        // Input: temperatures = [73,74,75,71,69,72,76,73]
        //Output: [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    static public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {

            if (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                while (!stack.isEmpty()) {
                    int[] last = stack.peek();
                    if (temperatures[i] > last[0]) {
                        result[last[1]] = i - last[1];
                        stack.pop();
                    } else {
                        stack.push(new int[]{temperatures[i], i});
                        break;
                    }
                }
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
