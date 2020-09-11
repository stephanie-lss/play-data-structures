package com.dp.linear.solution300;

/**
 * @author LiSheng
 * @date 2020/4/27 16:08
 */
class Solution4 {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = count;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[i] <= top[mid]) {
                    right = mid;
                } else if (nums[i] > top[mid]) {
                    left = mid + 1;
                }
            }
            if (left == count) {
                count++;
            }
            top[left] = nums[i];
        }
        return count;
    }
}