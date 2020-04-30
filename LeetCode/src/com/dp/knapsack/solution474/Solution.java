package com.dp.knapsack.solution474;

/**
 * @author LiSheng
 * @date 2020/4/24 16:21
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j][k]表示使用j个0和k个1能组合成在strs[0,i]字符串数组的最大数量
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        //base case：1-当0和1的个数都为0时无法组合成任何一个字符串
        //                    2-当i为0时表示没有字符串
        for (int i = 1; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int[] count = oneAndZeroCount(strs[i - 1]);
                    if (count[0] <= j && count[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - count[0]][k - count[1]] + 1, dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] oneAndZeroCount(String str) {
        int[] ret = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                ret[0]++;
            } else {
                ret[1]++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        System.out.println(new Solution().findMaxForm(arr, 5, 3));
    }
}
