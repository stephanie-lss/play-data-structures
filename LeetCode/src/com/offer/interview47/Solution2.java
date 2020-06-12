package com.offer.interview47;

/**
 * @author LiSheng
 * @date 2020/6/12 15:22
 */
public class Solution2 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        //dp[i][j]表示grid的第i - 1行和第j - 1列的最大礼物价值
        int[][] dp = new int[row + 1][col + 1];
        //base case
        dp[1][1] = grid[0][0];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }
}
