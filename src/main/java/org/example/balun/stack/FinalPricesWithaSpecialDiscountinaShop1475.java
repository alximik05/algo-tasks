package org.example.balun.stack;

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithaSpecialDiscountinaShop1475 {
//    Input: prices = [8,4,6,2,3]
//    Output: [4,2,4,2,3]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
    }

    static public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                Integer index = stack.pop();
                prices[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
