package com.yaole.problems.array;

public class BuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] prices = new int[] {2, 1, 2, 1, 0, 1, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int j = 0;
        int tmp = 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            tmp = prices[i] - prices[j];
            if (tmp < 0) {
                j = i;
            }
            else {
                if (tmp >= result) {
                    result = tmp;
                }
            }
        }
        return result;
    }
}
