package com.solution34;

/**
 * @author LiSheng
 * @date 2020/5/31 16:46
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBoard(nums, 0, nums.length - 1, target), rightBoard(nums, 0, nums.length - 1, target)};
    }

    private int leftBoard(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int rightBoard(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
