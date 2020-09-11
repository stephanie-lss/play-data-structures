package com.offer.interview42;

/**
 * @author LiSheng
 * @date 2020/6/8 11:16
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = -100;
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            pre = pre <= 0 ? nums[i - 1] : pre + nums[i - 1];
            max = Math.max(max, pre);
        }
        return max;
    }
}
