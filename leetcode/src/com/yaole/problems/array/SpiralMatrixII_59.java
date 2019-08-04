package com.yaole.problems.array;

public class SpiralMatrixII_59 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int max = n * n;
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        while (num <= max) {
            for (int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = num++;
            }
            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j++) {
                result[j][colEnd] = num++;
            }
            colEnd--;

            for (int i = colEnd; i >= colBegin; i--) {
                result[rowEnd][i] = num++;
            }
            rowEnd--;

            for (int j = rowEnd; j >= rowBegin; j--) {
                result[j][colBegin] = num++;
            }
            colBegin++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] a = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
