package com.offer.interview53_I;

/**
 * @author LiSheng
 * @date 2020/6/13 11:34
 */
public class Solution2 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = binarySearchFirst(nums, left, right, target);
        int last = binarySearchLast(nums, left, right, target);
        System.out.println(first);
        System.out.println(last);
        return first == -1 && last == -1 ? 0 : last - first + 1;
    }

    private int binarySearchFirst(int[] nums, int left, int right, int target) {
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
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int binarySearchLast(int[] nums, int left, int right, int target) {
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

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(new Solution2().search(nums, target));
    }
}
