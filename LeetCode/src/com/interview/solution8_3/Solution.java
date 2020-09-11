package com.interview.solution8_3;

/**
 * @author LiSheng
 * @date 2020/6/30 10:46
 */
class Solution {
    public int findMagicIndex(int[] nums) {
        return binaryFindMagicIndex(nums, 0, nums.length - 1);
    }

    private int binaryFindMagicIndex(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == mid) {
            return mid;
        }
        if (binaryFindMagicIndex(nums, left, mid - 1) == -1) {
            return binaryFindMagicIndex(nums, mid + 1, right);
        }
        if (binaryFindMagicIndex(nums, mid + 1, right) == -1) {
            return binaryFindMagicIndex(nums, left, mid - 1);
        }
        return 0;
    }
}