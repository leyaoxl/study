package com.yaole.problems.array;

public class MaximumAverageSubarrayI_643 {
    public static double findMaxAverage(int[] nums, int k) {
        /**
         * Double.NEGATIVE_INFINITY 表示负无穷
         * Double.MIN_VALUE 表示的是64位双精度值能表示的最小正数
         */
        double maxAvg = Double.NEGATIVE_INFINITY;
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                if (i > k - 1) {
                    sum = sum - nums[i - k];
                }
                if (sum / k > maxAvg) maxAvg = sum / k;
            }
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
