package com.offer.interview63;

/**
 * @author LiSheng
 * @date 2020/5/15 11:52
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_1 + prices[i], dp_i_0);
            dp_i_1 = Math.max(-prices[i], dp_i_1);
        }
        return dp_i_0;
    }
}