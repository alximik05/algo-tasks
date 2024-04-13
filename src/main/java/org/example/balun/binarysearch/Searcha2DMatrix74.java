package org.example.balun.binarysearch;

public class Searcha2DMatrix74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column > -1) {
            if (matrix[row][column] > target) {
                column--;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

     public boolean searchMatrix2(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (isLessOrEqual(mid, target, matrix)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int row = left / matrix[0].length;
        int column = left % matrix[0].length;
        return matrix[row][column] == target;
    }

    private boolean isLessOrEqual(int mid, int target, int[][] matrix) {
        int row = mid / matrix[0].length;
        int column = mid % matrix[0].length;
        return matrix[row][column] <= target;
    }
}
