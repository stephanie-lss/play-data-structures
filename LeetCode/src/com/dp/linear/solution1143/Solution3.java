package com.dp.linear.solution1143;

/**
 * @author LiSheng
 * @date 2020/4/20 14:38
 */
public class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < text1.length(); i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < text2.length(); i++) {
            dp[0][i] = text1.charAt(0) == text2.charAt(i) ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().longestCommonSubsequence("abcde", "ace"));
    }
}
