package com.yaole.problems.array;

/**
 * 解题思路
 * 如果长度为n的数组放0～n-1的n个数
 * 那么在有序的特殊情况下对应i-n[i]=0
 * 此时应该输出n
 * 则result = i - n[i] + 1 + result
 * result初始值是0
 */
public class MissingNumber_268 {
    public static void main(String[] args) {
        int[] nums = new int[] {1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i] + 1;
        }

        return result;
    }
}
