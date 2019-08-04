package com.leyao.algorithm.offer;

public class q48_不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        if (num1 == 0) return num2;
        if (num2 == 0) return num1;
        while (num2 != 0) {
            int tmp1 = num1 ^ num2;
            int tmp2 = (num1 & num2) << 1;
            num1 = tmp1;
            num2 = tmp2;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new q48_不用加减乘除做加法().Add(5, 4));
    }
}
