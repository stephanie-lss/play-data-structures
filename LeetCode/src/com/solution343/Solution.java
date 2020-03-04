package com.solution343;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/2/28 10:17
 */
public class Solution {
    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakFun(n);
    }

    private int breakFun(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max(res, i * (n - i), i * breakFun(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int max(int n1, int n2, int n3) {
        return Math.max(Math.max(n1, n2), n3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
