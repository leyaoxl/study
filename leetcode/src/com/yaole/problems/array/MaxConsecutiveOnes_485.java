package com.yaole.problems.array;

public class MaxConsecutiveOnes_485 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            }
            if (nums[i] == 0) {
                sum = 0;
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }
}
