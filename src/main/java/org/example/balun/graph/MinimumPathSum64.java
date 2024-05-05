package org.example.balun.graph;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
    static public int minPathSum(int[][] grid) {
        int[][] steps = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < steps.length; i++) {
            steps[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < steps[0].length; i++) {
            steps[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < steps.length; i++) {
            for (int j = 1; j < steps[0].length; j++) {
                if (i == 1 && j == 1) {
                    steps[i][j] = grid[i - 1][j - 1];
                    continue;
                }
                int min = Math.min(steps[i - 1][j], steps[i][j - 1]);
                steps[i][j] = min + grid[i - 1][j - 1];
            }
        }

        return steps[steps.length - 1][steps[0].length - 1];
    }
}
