package com.yaole.problems.array;

import java.util.Arrays;

public class SortArrayByParity_905 {
    public static int[] sortArrayByParity(int[] A) {
        int n = A.length;
        if (n == 1) return A;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            // 当左指针遇到奇数时停止
            if (A[i] % 2 == 0) {
                i++;
                continue;
            }
            // 当右指针遇到偶数时停止
            if (A[j] % 2 == 1) {
                j--;
                continue;
            }
            // 交换两数
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        sortArrayByParity(A);
        System.out.println(Arrays.toString(A));
    }
}
