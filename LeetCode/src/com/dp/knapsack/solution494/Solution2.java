package com.dp.knapsack.solution494;

/**
 * @author LiSheng
 * @date 2020/4/23 17:03
 */
class Solution2 {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        dfs(nums, S, 0);
        return res;
    }

    private void dfs(int[] nums, int S, int index) {
        if (index == nums.length) {
            if (S == 0) {
                res++;
            }
            return;
        }
        dfs(nums, S + nums[index], index + 1);
        dfs(nums, S - nums[index], index + 1);
    }
}
