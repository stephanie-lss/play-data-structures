package com.dp.linear.solution44;

/**
 * @author LiSheng
 * @date 2020/4/22 18:24
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                if (c1 == c2 || c1 == '?' || c2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c1 == '*' || c2 == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("abc", "?*c"));
        System.out.println(new Solution().isMatch("a", "ab*"));
        System.out.println(new Solution().isMatch("a", "aa*"));
        System.out.println(new Solution().isMatch("a", "?*"));
        System.out.println(new Solution().isMatch("ab", "*a*"));
        System.out.println(new Solution().isMatch("c", "*?*"));
        System.out.println(new Solution().isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
}