package com.yaole.problems.dynamicProgram;

import java.util.Arrays;

public class ArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0 || A.length == 1 || A.length == 2) return 0;
        int result = 0;
        //分别表示以这一位当做结尾时表示的等差数列数量
        for (int i = 2; i < A.length; i++) {
            int tmp = 0;
            int j = i;
            while (j - 2 >= 0) {
                if (A[j - 2] - A[j - 1] == A[j - 1] - A[j]) {
                    tmp++;
                    j--;
                }
                else break;
            }
            result += tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        ArithmeticSlices_413 arithmeticSlices_413 = new ArithmeticSlices_413();
        System.out.println(arithmeticSlices_413.numberOfArithmeticSlices(A));
    }
}
