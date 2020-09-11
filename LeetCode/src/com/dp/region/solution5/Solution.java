package com.dp.region.solution5;

/**
 * @author LiSheng
 * @date 2020/4/25 16:41
 */
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        //状态：2种
        //dp[i][j]表示s[i-1.j-1]对应的最长回文子串
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (dp[i + 1][j - 1] || j - i == 1) {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        String str = "";
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (dp[i][j] && str.length() < j - i + 1) {
                    str = s.substring(i - 1, j);
                }
            }
        }
        return str;
    }
}