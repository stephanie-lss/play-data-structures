package com.dp.knapsack.solution416;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/23 15:26
 */
class Solution3 {
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
        if (index < 0 || end < 0) {
            return false;
        }
        if (dfs(nums, index - 1, end - nums[index])) {
            return true;
        } else {
            return dfs(nums, index - 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5};
        System.out.println(new Solution3().canPartition(nums1));
        int[] nums2 = {1, 5, 11, 5};
        int[] nums3 = {1, 2, 3, 5};
        int[] nums4 = {1, 2, 5, 20};
        System.out.println(new Solution3().canPartition(nums2));
        System.out.println(new Solution3().canPartition(nums3));
        System.out.println(new Solution3().canPartition(nums4));
    }
}