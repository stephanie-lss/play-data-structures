package com.dp.region.solution730;

/**
 * @author LiSheng
 * @date 2020/4/23 11:13
 */
class Solution {
    public int countPalindromicSubsequences(String S) {
        int[][] dp = new int[S.length() + 3][S.length() + 3];
        for (int i = 0; i < S.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && S.charAt(left) != S.charAt(i)) {
                        left++;
                    }
                    while (left <= right && S.charAt(right) != S.charAt(i)) {
                        right--;
                    }
                    if (left == right) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else if (left > right) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                }
                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + 1000_000_007 : dp[i][j] % 1000_000_007;
            }
        }
        return dp[0][S.length() - 1];
    }

    public static void main(String[] args) {
        String S = "bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada";
        System.out.println(new Solution().countPalindromicSubsequences(S));
    }
}