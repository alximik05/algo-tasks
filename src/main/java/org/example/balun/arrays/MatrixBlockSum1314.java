package org.example.balun.arrays;

import java.util.Arrays;

public class MatrixBlockSum1314 {

    //    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//    Output: [
//    [12,21,16],
//    [27,45,33],
//    [24,39,28]]
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixBlockSum(
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}, 1)));

    }

    static public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length + 1;
        int columns = mat[0].length + 1;
        int[][] prefixMatrix = new int[rows][columns];

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                prefixMatrix[i][j] =
                                prefixMatrix[i - 1][j] +
                                prefixMatrix[i][j - 1] -
                                prefixMatrix[i - 1][j - 1] +
                                mat[i - 1][j - 1];

            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int r1 = Math.max(0, i - k) + 1;
                int c1 = Math.max(0, j - k) + 1;
                int r2 = Math.min(mat.length, i + k + 1);
                int c2 = Math.min(mat[0].length, j + k + 1);
                mat[i][j] = prefixMatrix[r2][c2] -
                        prefixMatrix[r1 - 1][c2] -
                        prefixMatrix[r2][c1 - 1] +
                        prefixMatrix[r1 - 1][c1 - 1];
            }
        }

        return mat;
    }
}
