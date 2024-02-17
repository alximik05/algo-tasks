package org.example.cracking_interview.array;

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa")); // a2b1c5a3
        System.out.println(compressString("abc")); // abc
    }


    static String compressString(String source) {
        if (source.isEmpty()) {
            return "";
        }
        char[] chars = source.toCharArray();

        if (compressedLength(chars) >= chars.length) { // необяз. доп проверка
            return source;
        }

        char previous = chars[0];
        StringBuilder builder = new StringBuilder();
        builder.append(previous);
        int charCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (previous == chars[i]) {
                charCount++;
            } else {
                builder.append(charCount);
                builder.append(chars[i]);
                previous = chars[i];
                charCount = 1;
            }
        }
        builder.append(charCount);
        return builder.length() < source.length() ? builder.toString() : source;
    }



     static int compressedLength(char[] chars) {
        char previous = chars[0];
        int result = 0;
        for (int i = 1; i < chars.length; i++) {
            if (previous == chars[i]) {
                continue;
            } else {
                previous = chars[i];
                result += 2; // один на символ, второй на кол-во символов
            }
        }
        result += 2; // на последний символ
        return result;
    }
}

