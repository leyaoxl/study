package com.yaole.problems.array;

public class TransposeMatrix_867 {
    public static void main(String[] args) {
        int[][] A = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = transpose(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] transpose(int[][] A) {
        if (A == null) return null;
        int m = A.length;
        int n = A[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
