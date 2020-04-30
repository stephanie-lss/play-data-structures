package com.top100.solution96;

/**
 * @author LiSheng
 * @date 2020/4/28 17:45
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
