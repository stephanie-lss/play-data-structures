package com.offer.interview14_I;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/17 17:21
 */
public class Solution2 {
    public int cuttingRope(int n) {
        //dp[i]表示绳子长度为n时的最大乘积
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //base case
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().cuttingRope(120));
    }
}
