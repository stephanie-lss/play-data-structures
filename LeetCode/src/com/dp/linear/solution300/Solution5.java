package com.dp.linear.solution300;

/**
 * @author LiSheng
 * @date 2020/4/29 21:02
 */
class Solution5 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = cnt;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[i]) {
                    left = mid + 1;
                } else if (nums[mid] > nums[i]) {
                    right = mid - 1;
                }
            }
            if (left == cnt) {
                cnt++;
            }
            top[left] = nums[i];
        }
        return cnt;
    }
}
