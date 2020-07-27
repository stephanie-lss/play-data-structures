package com.solution312;

/**
 * @author LiSheng
 * @date 2020/7/20 9:24
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int[] newNums = new int[len + 2];
        System.arraycopy(nums, 0, newNums, 1, len);
        newNums[0] = 1;
        newNums[len + 1] = 1;
        int max = 0;
        int[][] dp = new int[len + 3][len + 3];
        // dp[i][j]表示newNums[i - 1][j - 1],不包括边界（i-1,j-1）,
        // 戳破区间中所有气球时所能获得的最大硬币数量
        for (int i = len + 2; i >= 1; i--) {
            for (int j = i + 1; j <= len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i - 1] * newNums[k - 1] * newNums[j - 1]);
                }
            }
        }

        return dp[1][len + 2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int i = s.maxCoins(nums);
        int a = s.maxCoins(nums);

        System.out.println(s.maxCoins(nums));
    }
}
