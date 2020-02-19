package com.solution283;

/**
 * @author LiSheng
 * @date 2020/2/17 10:55
 */
class Solution3 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i != j) {
                    swap(nums, i++, j);
                } else {
                    i++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}