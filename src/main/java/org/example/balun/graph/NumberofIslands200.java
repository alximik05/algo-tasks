package org.example.balun.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands200 {
    public static void main(String[] args) {

        System.out.println(numIslandsBFS(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}
        ));
    }

     static public int numIslandsBFS(char[][] grid) {
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || checked[i][j]) {
                    continue;
                }
                startBFS(grid, checked, i, j);
                islands++;
            }
        }
        return islands;
    }

    static private void startBFS(char[][] grid, boolean[][] checked, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        checked[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] ij = queue.poll();
            int[][] neighbors = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] neighbor : neighbors) {
                int newRow = ij[0] + neighbor[0];
                int newCol = ij[1] + neighbor[1];
                if (newRow < 0 || newRow > grid.length - 1 || newCol < 0 || newCol > grid[0].length - 1 || checked[newRow][newCol] || grid[newRow][newCol] == '0') {
                    continue;
                }
                checked[newRow][newCol] = true;
                queue.add(new int[]{newRow, newCol});
            }

        }
    }

    static public int numIslandsDFS(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    startDFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    static private void startDFS(char[][] grid, int i, int j) {
        if (Math.min(i, j) < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        startDFS(grid, i + 1, j);
        startDFS(grid, i - 1, j);
        startDFS(grid, i, j + 1);
        startDFS(grid, i, j - 1);
    }


}
