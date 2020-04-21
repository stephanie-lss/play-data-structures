package com.solution198;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/21 19:47
 */
class Solution3 {

    int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int i) {
        int max = 0;
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        for (int j = i; j < nums.length; j++) {
            max = Math.max(max, nums[j] + helper(nums, j + 2));
        }
        memo[i] = max;
        return max;
    }
}
