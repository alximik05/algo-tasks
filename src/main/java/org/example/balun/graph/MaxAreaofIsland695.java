package org.example.balun.graph;

public class MaxAreaofIsland695 {

    public static void main(String[] args) {
    }

     public int maxAreaOfIsland(int[][] grid) {
        int maxSum = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currentMax = startDFS(i, j, grid, visited);
                    maxSum = Math.max(maxSum, currentMax);
                }
            }
        }
        return maxSum;
    }

     private int startDFS(int i, int j, int[][] grid,  boolean[][] visited) {
        if (Math.min(i, j) < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        int currentMax = 1;
        visited[i][j] = true;
        currentMax += startDFS(i + 1, j, grid, visited);
        currentMax += startDFS(i - 1, j, grid, visited);
        currentMax += startDFS(i, j + 1, grid, visited);
        currentMax += startDFS(i, j - 1, grid, visited);
        return currentMax;
    }

}
