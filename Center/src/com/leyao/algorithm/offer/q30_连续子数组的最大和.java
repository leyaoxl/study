package com.leyao.algorithm.offer;

public class q30_连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];
            if (tmp < 0) {
                if (tmp > sum) sum = tmp;
                tmp = 0;
            } else {
                if (tmp > sum) sum = tmp;
            }
        }
        return sum;
    }
}
