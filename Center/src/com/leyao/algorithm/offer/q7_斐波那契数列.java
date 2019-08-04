package com.leyao.algorithm.offer;

public class q7_斐波那契数列 {
    // 递归
    public int Fibonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return Fibonacci1(n - 2) + Fibonacci1(n - 1);
    }

    // 迭代
    public int Fibonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 1, b = 1, c = 0;
        while (n > 2) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }
}
