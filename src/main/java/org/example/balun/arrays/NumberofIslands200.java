package org.example.balun.arrays;

public class NumberofIslands200 {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    markAdjacent(grid, i, j, rows, columns);
                }
            }
        }
        return result;
    }

    private void markAdjacent(char[][] grid, int i, int j, int rows, int columns) {
        if (i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        markAdjacent(grid, i + 1, j, rows, columns);
        markAdjacent(grid, i - 1, j, rows, columns);
        markAdjacent(grid, i, j + 1, rows, columns);
        markAdjacent(grid, i, j - 1, rows, columns);
    }


    public int mamama(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    checkAdjcentConnections(grid, i, j, rows, columns);
                }
            }
        }
        return result;
    }

    private void checkAdjcentConnections(char[][] grid, int i, int j, int rows, int columns) {
        if (i < 0 || j < 0 || i > rows || j > columns || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        checkAdjcentConnections(grid, i + 1, j, rows, columns);
        checkAdjcentConnections(grid, i - 1, j, rows, columns);
        checkAdjcentConnections(grid, i, j + 1, rows, columns);
        checkAdjcentConnections(grid, i, j - 1, rows, columns);
    }
}
