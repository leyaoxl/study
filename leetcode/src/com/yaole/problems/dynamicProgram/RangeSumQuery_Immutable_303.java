package com.yaole.problems.dynamicProgram;

import java.util.Arrays;
import java.util.HashMap;

public class RangeSumQuery_Immutable_303 {
    private int[] arr;

    public RangeSumQuery_Immutable_303(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) arr[i] = nums[i];
            else arr[i] = nums[i] + arr[i - 1];
        }
        this.arr = arr;
        System.out.println(Arrays.toString(arr));
    }

    public int sumRange(int i, int j) {
        if (i == 0) return arr[j];
        return arr[j] - arr[i - 1];
    }
}
