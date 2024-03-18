package org.example.yandex.sprint1;

public class Q {
    public static void main(String[] args) {
        System.out.println(statistic(new int[]{-2, -1, 3, -1, -2}));
        System.out.println(statistic(new int[]{-2, 1, 1, -1, -2}));
    }

    static int statistic(int[] first) {


        int max = -1;

        for (int i = 0; i < first.length - 3; i++) {
            if (first[i] + first[i + 1] + first[i + 2] == 0) {
                int tmpMax = first[i] * first[i + 1] * first[i + 2];
                if (tmpMax > max) {
                    max = tmpMax;
                }
            }
        }

        return max;
    }
}
