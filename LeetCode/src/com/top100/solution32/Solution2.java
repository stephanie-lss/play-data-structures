package com.top100.solution32;

/**
 * @author LiSheng
 * @date 2020/5/8 20:51
 */
public class Solution2 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) != ')') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
