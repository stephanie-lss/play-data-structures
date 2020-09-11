package com.interview.solution8_11;

/**
 * @author LiSheng
 * @date 2020/4/23 9:43
 */
public class Solution2 {

    int[] money = {1, 5, 10, 25};

    public int waysToChange(int n) {
        int[][] dp = new int[4][n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= money[i]) {
                    //取
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i]]) % 1000_000_007;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[3][n];
    }
}
