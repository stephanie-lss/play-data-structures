package com.dp.knapsack.solution416;

/**
 * @author LiSheng
 * @date 2020/4/23 14:21
 */
class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int end = sum / 2;
        boolean[] dp = new boolean[end + 1];

        dp[0] = true;
        if (nums[0] == end) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == end) {
                return true;
            }
            for (int j = end; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new Solution2().canPartition(nums));
    }
}