package org.example.balun.graph;

public class UniquePaths62 {
    public static void main(String[] args) {
        System.out.println(uniquePathsDFS(3, 7));
    }

    private static int uniquePathsDFS(int m, int n) {
        int[][] steps = new int[m][n];

        return dfs(steps, 0, 0);
    }

    private static int dfs(int[][] steps, int m, int n) {
        if (Math.min(m, n) < 0 || m > steps.length - 1 || n > steps[0].length - 1 || steps[m][n] == 1) {
            return 0;
        }
        if (m == steps.length - 1 && n == steps[0].length - 1) {
            return 1;
        }
        steps[m][n] = 1;
        int count = 0;
        count += dfs(steps, m + 1, n);
        count += dfs(steps, m, n + 1);
        steps[m][n] = 0;
        return count;
    }

    private static int uniquePaths(int m, int n) {
        int[][] steps = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    steps[1][1] = 1;
                    continue;
                }
                steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
            }
        }
        return steps[m][n];
    }






}
