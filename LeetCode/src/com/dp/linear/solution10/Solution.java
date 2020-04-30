package com.dp.linear.solution10;

/**
 * @author LiSheng
 * @date 2020/4/22 20:52
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 2; i <= m; i += 2) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (c1 == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return dp[n][m];
    }
}
