package com.yaole.problems.array;

public class MonotonicArray_896 {
    public static boolean isMonotonic(int[] A) {
        int n = A.length;
        if (n == 1) return true;
        int num = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] - A[i - 1] <= 0) num++;
        }
        if (num == n) return true;
        num = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] - A[i - 1] >= 0) num++;
        }
        if (num == n) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1};
        System.out.println(isMonotonic(A));
    }
}
