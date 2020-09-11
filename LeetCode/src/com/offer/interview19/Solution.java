package com.offer.interview19;

/**
 * @author LiSheng
 * @date 2020/5/23 16:26
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        //dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        //base case
        dp[0][0] = true;
        for (int i = 2; i <= n2; i++) {
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char p1 = p.charAt(j - 1);
                if (p1 == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                } else if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(new Solution().isMatch(s, p));
    }
}