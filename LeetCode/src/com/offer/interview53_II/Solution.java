package com.offer.interview53_II;

/**
 * @author LiSheng
 * @date 2020/5/21 10:24
 */
class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else if (nums[mid] == mid) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.println(new Solution().missingNumber(nums));
    }
}