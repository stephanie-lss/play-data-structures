package com.solution410;

/**
 * @author LiSheng
 * @date 2020/7/25 12:10
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m == 0) {
            return 0;
        }
        long left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            long mid = left + (right - left) / 2;
            int tmp = 0, count = 1;
            for (int num : nums) {
                tmp += num;
                if (tmp > mid) {
                    tmp = num;
                    count++;
                }
            }
            if (count > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }
}