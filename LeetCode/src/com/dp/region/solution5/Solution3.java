package com.dp.region.solution5;

/**
 * @author LiSheng
 * @date 2020/5/21 8:31
 */
class Solution3 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        //dp[i][j]表示字符串的前s[i-1,j-1]之间是否最长回文子串
        boolean[][] dp = new boolean[n + 1][n + 1];
        //base case:每个单独的字符都构成了一个长度为1的回文子串
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        String str = String.valueOf(s.charAt(0));
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if ((i + 1 == j || dp[i + 1][j - 1]) && s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = true;
                    if (str.length() < j - i + 1) {
                        str = s.substring(i - 1, j);
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "a";
        System.out.println(new Solution3().longestPalindrome(str));
    }
}