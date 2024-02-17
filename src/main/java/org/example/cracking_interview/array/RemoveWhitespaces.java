package org.example.cracking_interview.array;

public class RemoveWhitespaces {

    public static void main(String[] args) {
        System.out.println(removeWhitespaces("Mr John   Smith    "));
//        System.out.println(removeWhitespacesInPlace("Mr John   Smith    ".toCharArray(), "Mr John   Smith    ".length()));
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


    static String removeWhitespacesInPlace(char[] str, int length) {
        int spaceCount = 0, newLength, i;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + spaceCount * 2;
        str[newLength] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        return new String(str);
    }
}
