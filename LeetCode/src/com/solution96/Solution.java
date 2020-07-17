package com.solution96;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/7/15 8:55
 */
class Solution {
    private int[] memo;

    public int numTrees(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += helper(i - 1) * helper(n - i);
        }
        memo[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}