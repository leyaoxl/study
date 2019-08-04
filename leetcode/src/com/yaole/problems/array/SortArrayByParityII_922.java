package com.yaole.problems.array;

import java.util.Arrays;

public class SortArrayByParityII_922 {
    public static int[] sortArrayByParityII(int[] A) {
        if (A == null) return A;
        int j = 1;
        int tmp = 0;
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] % 2 != 0) {
                while (A[j] % 2 == 1) {
                    j = j + 2;
                }
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }
}
