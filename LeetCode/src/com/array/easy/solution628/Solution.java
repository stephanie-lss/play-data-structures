package com.array.easy.solution628;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/29 22:30
 */
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int m2 = nums[0] * nums[1] * nums[n-1];
        return Math.max(m1,m2);
    }
}