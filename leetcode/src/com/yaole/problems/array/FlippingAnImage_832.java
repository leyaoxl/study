package com.yaole.problems.array;

import java.util.Arrays;

public class FlippingAnImage_832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        if (A == null) return A;
        int m = A.length;
        int n = A[0].length;
        int[][] B = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[i][n - j - 1];
                B[i][j] = B[i][j] ^ 1;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] B = flipAndInvertImage(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(Arrays.toString(B[i]));
        }
    }
}
