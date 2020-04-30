package com.dp.knapsack.solution416;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/23 21:10
 */
class Solution5 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //奇数直接返回false
        if ((sum & 1) == 1) {
            return false;
        }
        int end = sum >>> 1;

        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, end);
    }

    private boolean dfs(int[] nums, int index, int end) {
        if (end == 0) {
            return true;
        }
        if (end < 0 || (index >= 0 && nums[index] > end)) {
            return false;
        }
        for (int i = index; i >=0 ; i--) {
            if (dfs(nums, i - 1, end - nums[i])) {
                return true;
            }
        }
        return false;
    }
}
