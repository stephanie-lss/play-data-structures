package com.dp.linear.solution123;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/22 11:59
 */
class Solution {
    public int maxProfit(int[] prices) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i + 1] < prices[i]) {
                idx.add(i);
            }
        }
        int res = -1;
        for (Integer index : idx) {
            res = Math.max(helper(prices, 0, index) + helper(prices, index + 1, prices.length - 1), res);
        }
        return res != -1 ? res : helper(prices, 0, prices.length - 1);
    }

    private int helper(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int[] dp = new int[end - start + 1];
        dp[0] = 0;
        int min = prices[start];
        for (int i = start + 1; i <= end; i++) {
            min = Math.min(min, prices[i]);
            dp[i - start] = Math.max(dp[i - start - 1], prices[i] - min);
        }
        return dp[end - start];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new Solution().maxProfit(prices));
    }
}