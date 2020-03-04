package com.solution35;

/**
 * @author LiSheng
 * @date 2020/2/22 18:00
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
