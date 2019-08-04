package com.leyao.algorithm.offer;

public class q10_矩形覆盖 {
    // 递归
    public int RectCover1(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return RectCover1(target - 1) + RectCover1(target - 2);
    }

    // 迭代
    public int RectCover2(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int a = 1, b = 2, c = 0;
        while (target > 2) {
            c = a + b;
            a = b;
            b = c;
            target--;
        }
        return c;
    }
}
