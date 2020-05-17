package com.solution45;

/**
 * @author LiSheng
 * @date 2020/5/4 11:05
 */
class Solution4 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxReach = 0;
        int step = 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return step;
            }
            if (i == end) {
                step++;
                end = maxReach;
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution4().jump(nums));
    }
}