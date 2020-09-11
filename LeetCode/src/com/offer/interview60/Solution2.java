package com.offer.interview60;

/**
 * @author LiSheng
 * @date 2020/5/17 20:54
 */
class Solution2 {
    public static double[] twoSum(int n) {
        //dp[i][j]为当骰子数为i，和为j的情况数量。

        int[][] dp = new int[n + 1][n * 6 + 1];
        //base case—— 一个骰子时
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n * 6; j++) {
                for (int k = 1; k < 6 && j - k >= 1; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double[] res = new double[n * 5 + 1];
        double total = Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][i + n] / total;
        }
        return res;
    }

    public static void main(String[] args) {
        double[] doubles = new Solution2().twoSum(2);
        for (double aDouble : doubles) {
            System.out.print(aDouble + " ");
        }
    }
}