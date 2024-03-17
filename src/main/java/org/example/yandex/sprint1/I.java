package org.example.yandex.sprint1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class I {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(bitSum(
                new int[]{1, 0, 1, 0},
                new int[]{1, 0, 1, 1})));
        System.out.println(Arrays.toString(bitSum(new int[]{1}, new int[]{1})));


    }

    static Object[] bitSum(int[] a, int[] b) {
        int[] longer = b.length > a.length ? b : a;
        int[] shorter = b.length < a.length ? a : b;

        int razryad = 0;
        int delta = longer.length - shorter.length;


        List<Integer> re = new ArrayList<>();
        for (int i = longer.length - 1; i >= 0; i--) {
            int aa = longer[i];
            int bb = 0;

            if (i - delta >= 0) {
                bb = shorter[i - delta];
            }

            int tmpResult = razryad + aa + bb;

            int result = 0;

            switch (tmpResult) {
                case 3: {
                    razryad = 1;
                    result = 1;
                    break;
                }
                case 2: {
                    razryad = 1;
                    result = 0;
                    break;
                }
                default: {
                    razryad = 0;
                    result = tmpResult;
                }

            }
            re.add(0, result);
        }

        if (razryad > 0) {
            re.add(0, razryad);
        }

        return re.toArray();
    }
}
