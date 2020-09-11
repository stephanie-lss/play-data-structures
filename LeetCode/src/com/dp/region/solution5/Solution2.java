package com.dp.region.solution5;

/**
 * @author LiSheng
 * @date 2020/4/25 16:41
 * 超时
 */
class Solution2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        //状态：2种
        //dp[i][j]表示s[i-1.j-1]对应的最长回文子串
        String[][] dp = new String[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = String.valueOf(s.charAt(i - 1));
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if ((dp[i + 1][j - 1] != null && j - i - 1 == dp[i + 1][j - 1].length())) {
                        //dp[i + 1][j - 1] 是连续回文字符串
                        dp[i][j] = s.charAt(i - 1) + dp[i + 1][j - 1] + s.charAt(j - 1);
                    } else {
                        if (j - i == 1) {
                            //两个相邻的相同字符
                            dp[i][j] = s.charAt(i - 1) + "" + s.charAt(j - 1);
                        } else {
                            //dp[i + 1][j - 1] 不是连续回文字符串
                            dp[i][j] = dp[i + 1][j].length() > dp[i][j - 1].length() ? dp[i + 1][j] : dp[i][j - 1];
                        }
                    }
                } else {
                    //dp[i+1][j-1]是回文子串
                    dp[i][j] = dp[i + 1][j].length() > dp[i][j - 1].length() ? dp[i + 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        String str = "babadada";
        System.out.println(new Solution2().longestPalindrome(str));
    }
}
