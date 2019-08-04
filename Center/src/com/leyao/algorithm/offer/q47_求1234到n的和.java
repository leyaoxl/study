package com.leyao.algorithm.offer;

public class q47_求1234到n的和 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
