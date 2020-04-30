package com.dp.linear.solution877;

/**
 * @author LiSheng
 * @date 2020/4/26 19:11
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //dp[i][j][0]表示piles[i-1,j-1]中玩游戏先手所获得的最高分
        int[][][] dp = new int[n + 1][n + 1][2];
        //base case，当只有一个数时只有先手能得分
        for (int i = 1; i <= n; i++) {
            dp[i][i][0] = piles[i];
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j][0] = Math.max(piles[i - 1] + dp[i + 1][j][1], piles[j - 1] + dp[i][j - 1][1]);
                if (dp[i][j][0] == piles[i - 1] + dp[i + 1][j][1]) {
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[1][n][0] > dp[1][n][1];
    }
}
