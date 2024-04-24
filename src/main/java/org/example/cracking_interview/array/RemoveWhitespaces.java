package org.example.cracking_interview.array;

public class RemoveWhitespaces {

    public static void main(String[] args) {
//        System.out.println(removeWhitespaces("Mr John   Smith    "));
        System.out.println(removeWhitespacesInPlace("Mr John   Smith    ".toCharArray(), 15));
    }

    static String removeWhitespaces(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean duplicatedWhitespace = false;
        int lastNotWhitespaceSymbolIndex = getLastNotWhitespaceSymbolIndex(chars);
        for (int i = 0; i < lastNotWhitespaceSymbolIndex; i++) {
            if (chars[i] != ' ') {
                stringBuilder.append(chars[i]);
                duplicatedWhitespace = false;
            } else {
                if (duplicatedWhitespace) {
                    continue;
                } else {
                    stringBuilder.append("%20");
                    duplicatedWhitespace = true;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static int getLastNotWhitespaceSymbolIndex(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }


    static String removeWhitespacesInPlace(char[] chars, int len) {
        if (chars == null) {
            return "";
        }
        int spaceCount = 0;
        int index = 0;
        // first loop, locate last position
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        index = len + spaceCount * 2 - 1;
        // second loop, replace spaces from the end
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index] = '0';
                chars[index - 1] = '2';
                chars[index - 2] = '%';
                index -= 3;
            } else {
                chars[index] = chars[i];
                index--;
            }
        }
        return new String(chars).trim();
    }
}
