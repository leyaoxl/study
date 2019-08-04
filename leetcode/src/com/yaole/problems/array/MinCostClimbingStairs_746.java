package com.yaole.problems.array;

public class MinCostClimbingStairs_746 {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = 2; i <= n; i++) {
            dp2 = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
