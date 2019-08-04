package com.yaole.problems.array;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 243, 43, 6, 0, 23, 4, 0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length != 0 && nums != null) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[j] == 0 && nums[i] != nums[j] && nums[i] != 0) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                    j++;
                }
                if (nums[j] != 0) {
                    j++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
