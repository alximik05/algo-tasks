package org.example.cracking_interview.array;

public class ResetRowAndColumnInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {2, 0, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        printMatrix(matrix);
        resetRowAndColumnInMatrix(matrix);
        System.out.println();
        printMatrix(matrix);
    }

    private static void resetRowAndColumnInMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < column.length; i++) {
            if (column[i]) {
                nullifyColumn(matrix, i);
            }
        }
    }

    private static void nullifyRow(int[][] matrix, int rowNumber) {
        for (int i = 0; i < matrix[rowNumber].length; i++) {
            matrix[rowNumber][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int columnNumber) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][columnNumber] = 0;
        }
    }

    static void makeNullRowAndColumn(int[][] matrix, Coord coord) {
        for (int i = 0; i < matrix[coord.x].length; i++) {
            matrix[coord.x][i] = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][coord.y] = 0;
        }
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
