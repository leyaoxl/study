package com.yaole.problems.array;

import java.util.Arrays;

public class GameOfLife_289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        loop:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (m == 1 && n == 1) {
                    result[i][j] = 0;
                    break loop;
                }
                int num = 0;
                if (m == 1) {
                    if (j == 0) num = board[i][j + 1];
                    else if (j == n - 1) num = board[i][j - 1];
                    else num = board[i][j - 1] + board[i][j + 1];
                }
                else if (n == 1) {
                    if (i == 0) num = board[i + 1][j];
                    else if (i == m - 1) num = board[i - 1][j];
                    else num = board[i - 1][j] + board[i + 1][j];
                }
                else if (i == 0) {
                    if (j == 0) {
                        num = board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1];
                    }
                    else if (j == n - 1) {
                        num = board[i + 1][j] + board[i][j - 1] + board[i + 1][j - 1];
                    }
                    else num = board[i][j - 1] + board[i][j + 1] + board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1];
                }
                else if (i == m - 1) {
                    if (j == 0) {
                        num = board[i - 1][j] + board[i][j + 1] + board[i - 1][j + 1];
                    }
                    else if (j == n - 1) {
                        num = board[i - 1][j] + board[i][j - 1] + board[i - 1][j - 1];
                    }
                    else num = board[i][j - 1] + board[i][j + 1] + board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1];
                }
                else if (j == 0) {
                    num = board[i - 1][j] + board[i + 1][j] + board[i - 1][j + 1] + board[i][j + 1] + board[i + 1][j + 1];
                }
                else if (j == n - 1) {
                    num = board[i - 1][j] + board[i + 1][j] + board[i - 1][j - 1] + board[i][j - 1] + board[i + 1][j - 1];
                }
                else {
                    num = board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1] + board[i][j - 1] + board[i][j + 1] + board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1];
                }

                if (board[i][j] == 0 && num == 3) result[i][j] = 1;
                else if (board[i][j] == 1) {
                    if (num == 2 || num == 3) result[i][j] = 1;
                    else result[i][j] = 0;
                }
                else result[i][j] = 0;
            }
        }
        System.arraycopy(result, 0, board, 0, m);
    }

    public static void main(String[] args) {
        // int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] board = {{1}};
        GameOfLife_289 gameOfLife_289 = new GameOfLife_289();
        gameOfLife_289.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
