package com.array.easy.solution121;

/**
 * @author LiSheng
 * @date 2020/3/28 17:56
 */
public class SolutionDp {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minPay = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPay > prices[i]) {
                minPay = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - minPay);
        }
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new SolutionDp().maxProfit(prices));
    }
}
