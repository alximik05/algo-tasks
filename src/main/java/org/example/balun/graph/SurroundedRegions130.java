package org.example.balun.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions130 {

    public  void main(String[] args) {

        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

     public void solve(char[][] board) {
        boolean[][] zeros = new boolean[board.length][board[0].length];

        for (int i = 0; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O') {
                startBFS(board, zeros, 0, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') {
                startBFS(board, zeros, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length - 1; i++) {
            if (board[board.length - 1][i] == 'O') {
                startBFS(board, zeros, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                startBFS(board, zeros, i, 0);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !zeros[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void startBFS(char[][] board, boolean[][] zeros, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r, c});
        zeros[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            List<int[]> steps = List.of(
                    new int[]{0, 1},
                    new int[]{1, 0},
                    new int[]{-1, 0},
                    new int[]{0, -1}
            );

            for (int[] step : steps) {
                int newR = step[0] + current[0];
                int newC = step[1] + current[1];
                if (inBound(board, newR, newC) && board[newR][newC] == 'O' && !zeros[newR][newC]) {
                    queue.add(new int[]{newR, newC});
                    zeros[newR][newC] = true;
                }
            }
        }
    }

    boolean inBound(char[][] board, int r, int c) {
        return Math.min(r, c) > 0 && r < board.length - 1 && c < board[0].length - 1;
    }

     private void startDFS(char[][] board, boolean[][] zeros, int r, int c) {
        if (Math.min(r, c) < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] == 'X' || zeros[r][c]) {
            return;
        }
        zeros[r][c] = true;

        startDFS(board, zeros, r + 1, c);
        startDFS(board, zeros, r - 1, c);
        startDFS(board, zeros, r, c + 1);
        startDFS(board, zeros, r, c - 1);
    }


}
