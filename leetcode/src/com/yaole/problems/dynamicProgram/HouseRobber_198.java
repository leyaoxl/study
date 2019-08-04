package com.yaole.problems.dynamicProgram;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] tmpArr = new int[n];
        //从后往前遍历
        tmpArr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int a = 0, b = 0;
            //考虑在i房子抢劫
            if (i + 1 >= n - 1) a = nums[i];
            else a = nums[i] + tmpArr[i + 2];
            //不考虑在i房子抢劫
            if (i + 2 >= n - 1) b = nums[i + 1];
            else b = nums[i + 1] + tmpArr[i + 3];
            //在二者之间选取最大值
            tmpArr[i] = Math.max(a, b);
        }
        return tmpArr[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        HouseRobber_198 houseRobber_198 = new HouseRobber_198();
        System.out.println(houseRobber_198.rob(nums));
    }
}
