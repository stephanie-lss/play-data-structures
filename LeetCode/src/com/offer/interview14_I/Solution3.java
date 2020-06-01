package com.offer.interview14_I;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/6/1 10:58
 */
public class Solution3 {
    private int[] memo;

    public int cuttingRope(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.max(i * dfs(n - i), i * (n - i)), res);
        }
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().cuttingRope(10));
    }
}
