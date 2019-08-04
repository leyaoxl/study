package com.yaole.problems.math;

public class NumberOf1Bits_191 {
    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int count = 1;
        int tmp = n;
        while ((tmp & (tmp - 1)) != 0) {
            tmp = tmp & (tmp - 1);
            count++;
        }
        return count;
    }
}
