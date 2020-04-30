package com.solution338;

/**
 * @author LiSheng
 * @date 2020/4/28 10:57
 */
class Solution2 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = (i & 1) == 0 ? dp[i >> 1] : dp[i - 1] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().countBits(2));
    }
}
