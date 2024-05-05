package org.example.balun.math;

public class CountPrimes204 {

    public int countPrimes(int n) {
        boolean[] array = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (array[i]) {
                continue;
            } else {
                result++;
                for (long j = i * i; j < n; j = j + i) {
                    array[(int)j] = true;
                }
            }

        }
        return result;
    }
}
