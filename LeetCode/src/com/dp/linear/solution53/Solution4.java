package com.dp.linear.solution53;

/**
 * @author LiSheng
 * @date 2020/5/3 9:38
 */
class Solution4 {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = pre;
        for (int i = 2; i < nums.length; i++) {
            pre = pre < 0 ? nums[i] : pre + nums[i];
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution4().maxSubArray(nums));
    }
}
