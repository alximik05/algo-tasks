package org.example.balun.arrays;

public class RangeSumQuery2D304 {
    class NumMatrix {

        int[][] prefixMatrix;

        public NumMatrix(int[][] matrix) {

            prefixMatrix = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < prefixMatrix.length; i++) {
                for (int j = 0; j < prefixMatrix[0].length; j++) {
                    prefixMatrix[i][j] = 0;
                }
            }

            for (int i = 1; i < prefixMatrix.length; i++) {
                for (int j = 1; j < prefixMatrix[0].length; j++) {
                    prefixMatrix[i][j] =
                            prefixMatrix[i - 1][j] +
                                    prefixMatrix[i][j - 1] -
                                    prefixMatrix[i - 1][j - 1] +
                                    matrix[i - 1][j - 1];

                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixMatrix[row2 + 1][col2 + 1] -
                    prefixMatrix[row1][col2 + 1] -
                    prefixMatrix[row2 + 1][col1] +
                    prefixMatrix[row1][col1];
        }
    }
}


