package com.leyao.algorithm.offer;

public class q12_数值的整数次方 {
    public double Power(double base, int exponent) {
        double b = base;
        int e = exponent;
        if (b == 0) {
            if (e == 0) throw new RuntimeException("0的0次方没有意义");
            else return 0;
        }
        if (e == 0) return 1;
        if (e < 0) e = -e;
        double result = 1;
        while (e > 0) {
            result *= b;
            e--;
        }
        if (exponent < 0) result = 1 / result;
        return result;
    }
}
