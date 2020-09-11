package com.array.easy.interview16_17;

/**
 * @author LiSheng
 * @date 2020/4/1 22:10
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            b = Math.max(b + nums[i], nums[i]);
            res = Math.max(b, res);
        }
        return res;
    }
}
