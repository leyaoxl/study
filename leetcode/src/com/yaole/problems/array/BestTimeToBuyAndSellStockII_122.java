package com.yaole.problems.array;

public class BestTimeToBuyAndSellStockII_122 {
    // public static int maxProfit(int[] prices) {
    //     int result = 0;
    //     for (int i = 1; i < prices.length; i++) {
    //         if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
    //     }
    //     return result;
    // }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }



}
