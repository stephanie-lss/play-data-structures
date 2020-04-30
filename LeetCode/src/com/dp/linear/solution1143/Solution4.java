package com.dp.linear.solution1143;

/**
 * @author LiSheng
 * @date 2020/4/26 16:27
 */
public class Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        //状态：text1，text2
        //dp[i][j]表示text1的前i个字母和text2的前j个字符的最长公共序列
        int[][] dp = new int[n1 + 1][n2 + 1];
        //base case:当i=0||j==0时，dp[i][j]为0
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String tex1 = "abc";
        String tex2 = "abc";
        System.out.println(new Solution4().longestCommonSubsequence(tex1, tex2));
    }
}
