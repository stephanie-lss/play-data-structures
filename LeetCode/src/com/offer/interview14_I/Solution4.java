package com.offer.interview14_I;

/**
 * @author LiSheng
 * @date 2020/6/1 11:06
 */
public class Solution4 {
    public int cuttingRope(int n) {
        //dp[i]为绳子长度为i时的最大乘积
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().cuttingRope(10));
    }
}
