package com.leyao.algorithm.offer;

public class q8_跳台阶 {
    // 递归
    public int JumpFloor1(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor1(target - 2) + JumpFloor1(target - 1);
    }

    // 迭代
    public int JumpFloor2(int target) {
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
