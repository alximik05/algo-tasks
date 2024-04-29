package org.example.balun.hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {

    public static void main(String[] args) {

        char[][] charMatrix = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] charMatrix2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(charMatrix2));

    }
     static public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows.contains(board[i][j])) {
                    return false;
                }
                rows.add(board[i][j]);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            Set<Character> column = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (column.contains(board[i][j])) {
                    return false;
                }
                column.add(board[i][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkInSquare(board, i * 3, j * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkInSquare(char[][] board, int startRow, int startColumn) {
        Set<Character> squarik = new HashSet<>();
        for (int i = startRow; i < 3 + startRow; i++) {
            for (int j = startColumn; j < 3 + startColumn; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (squarik.contains(board[i][j])) {
                    return false;
                }
                squarik.add(board[i][j]);
            }
        }
        return true;
    }

}
