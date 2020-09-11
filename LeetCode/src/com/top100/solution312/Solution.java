package com.top100.solution312;

/**
 * @author LiSheng
 * @date 2020/5/1 9:37
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n + 2];
        coins[0] = 1;
        coins[n + 1] = 1;
        System.arraycopy(nums, 0, coins, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = coins[i - 1] * coins[i] * coins[i + 1];
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + coins[i - 1] * coins[k] * coins[j + 1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] coins = {3, 1, 5, 8};
        System.out.println(new Solution().maxCoins(coins));
    }
}