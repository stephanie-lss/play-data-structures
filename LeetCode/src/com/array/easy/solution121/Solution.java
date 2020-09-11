package com.array.easy.solution121;

/**
 * @author LiSheng
 * @date 2020/3/28 17:56
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //数组为空
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        //没有交易完成的情况
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                break;
            }
            if (i == prices.length - 2) {
                return 0;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            int pay = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - pay > max) {
                    max = prices[j] - pay;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {};
        System.out.println(new Solution().maxProfit(prices));
    }
}
