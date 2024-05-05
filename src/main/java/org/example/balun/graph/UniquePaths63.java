package org.example.balun.graph;


public class UniquePaths63 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstaclesDFS(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

    }

    static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] steps = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for (int i = 1; i < steps.length; i++) {
            for (int j = 1; j < steps[0].length; j++) {
                if (i == 1 && j == 1) {
                    steps[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    steps[i][j] = 0;
                    continue;
                }
                steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
            }
        }
        return steps[steps.length - 1][steps[0].length - 1];
    }

    static public int uniquePathsWithObstaclesDFS(int[][] obstacleGrid) {
        return dfs(obstacleGrid, 0, 0);
    }

    private static int dfs(int[][] obstacleGrid, int r, int c) {
        if (Math.min(r, c) < 0 || r > obstacleGrid.length - 1 || c > obstacleGrid[0].length - 1 || obstacleGrid[r][c] == 1) {
            return 0;
        }
        if (r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            return 1;
        }
        int count = 0;
        obstacleGrid[r][c] = 1;
        count += dfs(obstacleGrid, r + 1, c);
        count += dfs(obstacleGrid, r, c + 1);
        obstacleGrid[r][c] = 0;
        return count;
    }
}
