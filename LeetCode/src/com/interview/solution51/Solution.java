package com.interview.solution51;

/**
 * @author LiSheng
 * @date 2020/4/24 9:32
 */
class Solution {
    int res = 0;

    public int reversePairs(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length - 1) {
            return;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] > nums[i]) {
                res++;
            }
        }
        dfs(nums, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new Solution().reversePairs(nums));
    }
}
