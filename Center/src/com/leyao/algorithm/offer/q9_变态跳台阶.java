package com.leyao.algorithm.offer;

public class q9_变态跳台阶 {
    public int JumpFloorII(int target) {
        if (target == 0) return 0;
        return (int) Math.pow(2, target - 1);
    }
}
