package com.yaole.problems.dynamicProgram;

import java.util.Arrays;

public class CountingBits_338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < result.length; i++) {
            int tmp = i;
            int count = 1;
            //将当前数与前一数按位相与，不等于0时自增1
            while ((tmp & (tmp - 1)) != 0) {
                tmp = tmp & (tmp - 1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits_338 countingBits_338 = new CountingBits_338();
        System.out.println(Arrays.toString(countingBits_338.countBits(1)));
    }
}
