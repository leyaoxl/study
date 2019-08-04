package com.leyao.algorithm.offer;

public class q11_二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
