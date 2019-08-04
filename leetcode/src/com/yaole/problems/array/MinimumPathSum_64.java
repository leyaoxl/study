package com.yaole.problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] = grid[i][j] + grid[i][j - 1];
                else if (j == 0) grid[i][j] = grid[i][j] + grid[i - 1][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    // public int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int i = 0, j = 0;
    //     int sum = 0;
    //     int tmp = Integer.MAX_VALUE;
    //     return helper(grid, i, j, m, n, sum, tmp);
    // }
    //
    // private int helper(int[][] grid, int i, int j, int m, int n, int sum, int tmp) {
    //     if (i == m || j == n) return tmp;
    //     if (m == i + 1 && n == j + 1) {
    //         sum += grid[i][j];
    //         if (sum < tmp) {
    //             tmp = sum;
    //             return tmp;
    //         }
    //     }
    //     sum += grid[i][j];
    //     i = i + 1;
    //     tmp = helper(grid, i, j, m, n, sum, tmp);
    //     i = i - 1;
    //     j = j + 1;
    //     tmp = helper(grid, i, j, m, n, sum, tmp);
    //     return tmp;
    // }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {1, 1}};
        MinimumPathSum_64 minimumPathSum_64 = new MinimumPathSum_64();
        System.out.println(minimumPathSum_64.minPathSum(grid));
    }
}
