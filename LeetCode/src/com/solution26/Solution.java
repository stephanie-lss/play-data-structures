package com.solution26;

/**
 * @author LiSheng
 * @date 2020/2/17 11:36
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return ++k;
    }
}
