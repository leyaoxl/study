package com.leyao.algorithm.offer;

public class q31_整数中1出现的次数_从1到n整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        int count = 0;
        while (n > 0) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '1') count++;
            }
            n--;
        }
        return count;
    }
}
