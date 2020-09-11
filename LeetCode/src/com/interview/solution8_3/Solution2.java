package com.interview.solution8_3;

/**
 * @author LiSheng
 * @date 2020/7/31 9:01
 */
public class Solution2 {
    public int findMagicIndex(int[] nums) {
        int left = 0, right = 0;
        if (nums == null || (right = nums.length) == 0) {
            return -1;
        }
        return binaryFindMagicIndex(nums, left, right - 1);
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
