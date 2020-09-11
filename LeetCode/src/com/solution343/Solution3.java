package com.solution343;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/7/30 8:56
 */
public class Solution3 {

    private int[] memo;

    public int integerBreak(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(Math.max(max, i * (n - i)), i * helper(n - i));
        }
        memo[n] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().integerBreak(10));
    }
}
