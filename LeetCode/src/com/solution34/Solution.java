package com.solution34;

/**
 * @author LiSheng
 * @date 2020/4/29 12:36
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, 0, nums.length, target),right_bound(nums, 0, nums.length, target)};
    }

    private int right_bound(int[] nums, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                return right_bound(nums, left, mid, target);
            } else if (nums[mid] <= target) {
                return right_bound(nums, mid + 1, right, target);
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    private int left_bound(int[] nums, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                return left_bound(nums, left, mid, target);
            } else if (nums[mid] < target) {
                return left_bound(nums, mid + 1, right, target);
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }
}