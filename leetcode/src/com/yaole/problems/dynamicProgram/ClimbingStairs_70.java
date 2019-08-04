package com.yaole.problems.dynamicProgram;

import java.util.Arrays;

public class ClimbingStairs_70 {
    /**
     * 变量存储法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 1) return a;
        if (n == 2) return b;
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // /**
    //  * 数组存储法
    //  * @param n
    //  * @return
    //  */
    // public int climbStairs(int n) {
    //     int[] nums = new int[n + 1];
    //     int i = 1;
    //     while (i < n + 1) {
    //         if (i == 1) nums[i++] = 1;
    //         else if (i == 2) nums[i++] = 2;
    //         else {
    //             nums[i] = nums[i - 1] + nums[i - 2];
    //             i++;
    //         }
    //     }
    //     return nums[n];
    // }

    // /**
    //  * 递归法
    //  * @param n
    //  * @return
    //  */
    // public int climbStairs(int n) {
    //     return helper(n, 0, 0);
    // }
    //
    // private int helper(int n, int sum, int num) {
    //     if (sum > n) return num;
    //     if (sum == n) {
    //         num++;
    //         return num;
    //     }
    //     sum += 1;
    //     num = helper(n, sum, num);
    //     sum -= 1;
    //     sum += 2;
    //     num = helper(n, sum, num);
    //     return num;
    // }

    public static void main(String[] args) {
        ClimbingStairs_70 climbingStairs_70 = new ClimbingStairs_70();
        System.out.println(climbingStairs_70.climbStairs(5));
    }
}
