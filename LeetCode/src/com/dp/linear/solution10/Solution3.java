package com.dp.linear.solution10;

/**
 * @author LiSheng
 * @date 2020/4/26 20:55
 */
public class Solution3 {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        //状态：2种
        //dp[i][j]:表示s前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        //base case
        dp[0][0] = true;
        for (int i = 2; i <= n2; i += 2) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    //匹配 || c*不匹配任何字符
                    dp[i][j] = (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1) && dp[i - 1][j]) || dp[i][j - 2];
                } else if (c == '.' || c == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String str1 = "mississippi";
        String p1 = "mis*is*ip*.";
        System.out.println(new Solution3().isMatch(str1, p1));
    }
}
