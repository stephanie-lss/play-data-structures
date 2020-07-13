package com.offer.interview60;

/**
 * @author LiSheng
 * @date 2020/7/4 15:53
 */
public class Solution4 {
    public double[] twoSum(int n) {
        if (n <= 0) {
            return new double[0];
        }
        //dp[i][j]表示骰子个数为i时点数为j时的总次数
        int[][] dp = new int[n + 1][n * 6 + 1];
        //base case
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        double totalCount = Math.pow(6, n);
        for (int i = 2; i <= n; i++) {
            for (int j = n; j <= 6 * n; j++) {
                for (int k = 1; k <= 6 && j - k >= i - 1; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double[] res = new double[5 * n + 1];
        int idx = 0;
        for (int j = n; j <= 6 * n; j++) {
            res[idx++] = dp[n][j] / totalCount;
        }
        return res;
    }

    public static void main(String[] args) {
        double[] res = new Solution4().twoSum(2);
        for (double re : res) {
            System.out.print(re + " ");
        }
    }
}
