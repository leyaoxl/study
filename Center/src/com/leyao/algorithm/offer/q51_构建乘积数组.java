package com.leyao.algorithm.offer;

public class q51_构建乘积数组 {
    public int[] multiply(int[] A) {
        if (A == null) return null;
        if (A.length == 0) return A;
        int n = A.length;
        int[] B = new int[n];
        B[0] = 1;
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = n - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }
}
