package com.yaole.problems.array;

public class LongestContinuousIncreasingSubsequence_674 {
    public static void main(String[] args) {
        int[] nums = new int[] {2};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        int tmpResult = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                tmpResult++;
                j = i;
                continue;
            }
            if (tmpResult > result) {
                result = tmpResult;
            }
            tmpResult = 1;
            j = i;
            continue;
        }
        if (tmpResult > result) {
            result = tmpResult;
        }
        return result;
    }
}
