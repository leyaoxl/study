package com.yaole.problems.array;

public class LargestNumberAtLeastTwiceOfOthers_747 {
    public static void main(String[] args) {
        int[] nums = new int[] {0};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int rootMax = 0;
        int subMax = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= rootMax) {
                subMax = rootMax;
                rootMax = nums[i];
                result = i;
            }
            else if (nums[i] >= subMax) {
                subMax = nums[i];
            }
        }

        if (rootMax >= (2 * subMax)) {
            return result;
        }
        else {
            return -1;
        }
    }
}
