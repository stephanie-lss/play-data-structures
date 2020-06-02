package com.offer.interview19;

/**
 * @author LiSheng
 * @date 2020/6/2 10:44
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        //dp[i][j]表示s的前i个字符与p的前j个字符是否匹配
        boolean[][] dp = new boolean[sLen + 1][p.length() + 1];
        //base case
        dp[0][0] = true;
        for (int i = 2; i <= pLen; i += 2) {
            dp[0][i] = dp[0][i - 2] && (p.charAt(i - 1) == '*');
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char k = p.charAt(j - 1);
                if (k == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                } else {
                    if (s.charAt(i - 1) == k || k == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isMatch("aaaaaaa","a*"));
    }
}
