package org.example.yandex.sprint1;

import java.util.Arrays;

public class P {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(combination(new int[]{2, 3})));
    }

    static int[] combination(int[] first) {
        String[] array = new String[10];

        array[0] = "";
        array[1] = "";
        array[2] = "abc";
        array[3] = "def";
        array[4] = "ghi";
        array[5] = "jkl";
        array[6] = "mno";
        array[7] = "pqrs";
        array[8] = "tuv";
        array[9] = "wxyz";

        for (int i = 0; i < first.length; i++) {
            char[] chars = array[first[i]].toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {

                for (int i2 = i1 + 1; i2 < first.length; i2++) {
                    char[] chars2 = array[first[i2]].toCharArray();

                    for (int i3 = 0; i3 < chars2.length; i3++) {
                        System.out.println(chars[i1] + chars2[i3]);
                    }
                }


            }
        }

        return null;
    }
}
