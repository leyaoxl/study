package com.yaole.problems.array;

public class MaximumSubarray_53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];// 数组长度为1时直接返回
        int[] result = new int[n];// 定义一个结果数组存取以索引结尾的最大子数组之和
        result[0] = nums[0];// 结果数组第一个数是原数组第一个元素
        int max = nums[0];// 保存最大值的变量，初始化为原数组第一个元素
        for (int i = 1; i < n; i++) {
            // 先将原数组对应元素赋值到结果数组对应位置
            result[i] = nums[i];
            // 当结果数组前一位置值大于0时，当前位置即为二者之和
            if (result[i - 1] > 0) result[i] = result[i] + result[i - 1];
            // 当前元素子数组之和大于max时进行替换
            if (result[i] > max) max = result[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

}
