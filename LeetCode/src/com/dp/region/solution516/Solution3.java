package com.dp.region.solution516;

/**
 * @author LiSheng
 * @date 2020/4/23 10:22
 */
class Solution3 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][s.length()];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(new Solution3().longestPalindromeSubseq(s));
    }
}