package org.example.yandex.sprint1;

public class L {
    public static void main(String[] args) {
        System.out.println(extraLetter("abcd", "abcde"));
        System.out.println(extraLetter("go", "ogg"));

    }

    static char extraLetter(String source, String target) {
        char[] charSource = source.toCharArray();
        char[] charTarget = target.toCharArray();

        int[] buffer = new int[122];
        for (char current : charSource) {
            buffer[current]++;
        }

        for (char current : charTarget) {
            buffer[current]--;
        }

        for (int j = 0; j < buffer.length; j++) {
            int i = buffer[j];
            if (i != 0) {
                return (char) j;
            }
        }
        return 0;
    }
}
