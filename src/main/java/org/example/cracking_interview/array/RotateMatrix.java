package org.example.cracking_interview.array;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println();
        printMatrix(matrix);
    }

    public static void rotateMatrix(int[][] matrix) {
            // идем по слоям - берем половину потому что надо половина строк
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - 1 - layer;

            // мы зажаты между first и last - идем по нему
            for (int i = first; i < last; i++) {
                // нужен оффсет для движения по верхней границы
                int offset = i - first;
                // сохраняем верхнюю чтобы не потерять
                int tmp = matrix[first][i];
                //  верхнюю меняем на левую
                matrix[first][i] = matrix[last - offset][first];
                // левую меняем на нижнюю
                matrix[last - offset][first] = matrix[last][last - offset];
                //  нижнюю меняем на правую
                matrix[last][last - offset] = matrix[i][last];
                //   правую меняем на верхнюю
                matrix[i][last] = tmp;
            }
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
