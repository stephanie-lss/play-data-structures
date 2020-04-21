package com.dp.linear.solution198;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/7 11:54
 */
public class Solution {

    private int[] v;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        v = new int[nums.length];
        Arrays.fill(v, -1);
        int index = 0;
        return tryRob(nums, index);
    }

    private int tryRob(int[] nums, int index) {
        int res = 0;
        if (index >= nums.length) {
            return 0;
        }
        if (v[index] != -1) {
            return v[index];
        }
        for (int i = index; i < nums.length; i++) {
            res = Math.max(nums[i] + tryRob(nums, i + 2), res);
        }
        v[index] = res;
        return res;
    }
}
