package com.offer.interview53_II;

/**
 * @author LiSheng
 * @date 2020/6/13 11:57
 */
public class Solution2 {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (right == 0) {
            return nums[left] == 0 ? 1 : 0;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left;
    }
}
