package com.array.easy.solution122;


/**
 * @author LiSheng
 * @date 2020/3/28 18:33
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
