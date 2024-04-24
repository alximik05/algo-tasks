package org.example.balun.stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsinaString151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

//    Input: s = "the sky is blue"
//    Output: "blue is sky the"
    static public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int start = getFirstNotWhiteSpaceChar(charArray);
        int end = getLastNotWhiSpaceChar(charArray);
        char[] chars = Arrays.copyOfRange(charArray, start, end + 1);

        String trimmed = new String(chars);
        String[] words = trimmed.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                builder.append(words[i]);
                builder.append(" ");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private static int getLastNotWhiSpaceChar(char[] charArray) {
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    private static int getFirstNotWhiteSpaceChar(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}
