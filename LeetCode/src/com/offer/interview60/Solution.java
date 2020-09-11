package com.offer.interview60;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/17 18:16
 */
class Solution {

    int[][] memo;

    public double[] twoSum(int n) {
        memo = new int[n * 6 + 1][n + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        double[] res = new double[n * 5 + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = calHelper(i + n, n) / Math.pow(6, n);
        }
        return res;
    }

    private int calHelper(int i, int n) {
        if (i >= 0 && n >= 0 && memo[i][n] != -1) {
            return memo[i][n];
        }
        if (n == 0) {
            if (i == 0) {
                return 1;
            }
            return 0;
        }
        if (i <= 0) {
            return 0;
        }
        int count = 0;
        for (int j = 1; j <= 6; j++) {
            count += calHelper(i - j, n - 1);
        }
        memo[i][n] = count;
        return count;
    }

    public static void main(String[] args) {
        double[] doubles = new Solution().twoSum(2);
        for (double aDouble : doubles) {
            System.out.print(aDouble + " ");
        }
    }
}