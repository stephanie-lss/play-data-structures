package com.solution283;

/**
 * @author LiSheng
 * @date 2020/2/17 10:55
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}