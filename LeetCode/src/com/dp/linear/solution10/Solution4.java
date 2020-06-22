package com.dp.linear.solution10;

/**
 * @author LiSheng
 * @date 2020/6/20 14:25
 */
public class Solution4 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        //base case
        dp[0][0] = true;
        for (int i = 2; i <= pLen; i++) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char c = s.charAt(i - 1);
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == c));
                } else if (p.charAt(j - 1) == c || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }
}
