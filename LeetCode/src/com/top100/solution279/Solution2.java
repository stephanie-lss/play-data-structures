package com.top100.solution279;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/1 13:02
 * NOT AC
 */
class Solution2 {
    int[][] memo;

    public int numSquares(int n) {
        memo = new int[n + 1][n + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(n, 0);
    }

    private int dfs(int n, int step) {
        if (memo[n][step] != -1) {
            return memo[n][step];
        }
        if (n == 0) {
            return step;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(dfs(n - i * i, step + 1), min);
        }
        memo[n][step] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().numSquares(7168));
    }
}