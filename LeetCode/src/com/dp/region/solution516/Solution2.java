package com.dp.region.solution516;

/**
 * @author LiSheng
 * @date 2020/4/23 10:22
 */
class Solution2 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        //状态：字符串的起始索引
        //dp[i][j]表示s[i-1,j-1]的最长回文序列长度
        int[][] dp = new int[n + 1][n + 1];
        //base case
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
//        从下往上，从左往右遍历
//        for (int i = n - 1; i >= 1; i--) {
//            for (int j = i + 1; j <= n; j++) {
//                if (s.charAt(i - 1) == s.charAt(j - 1)) {
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//      沿对角线开始遍历，从上往下，从左往右遍历
        for (int p = 1; p < n; p++) {
            for (int i = 1; i <= n - p; i++) {
                int j = i + p;
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(new Solution2().longestPalindromeSubseq(s));
    }
}