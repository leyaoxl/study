package com.yaole.problems.array;

import java.util.Arrays;

/**
 * 第561题
 *
 * 给定长度为2n的数组, 你的任务是将这些数分成n对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
public class ArrayPartition1_561 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 3, 2, 5, 6};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
