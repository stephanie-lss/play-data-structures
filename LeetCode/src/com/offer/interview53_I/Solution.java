package com.offer.interview53_I;

/**
 * @author LiSheng
 * @date 2020/5/19 9:14
 */
class Solution {
    public int search(int[] nums, int target) {
        int last = last(nums, target);
        int first = first(nums, target);
        return last == -1 ? 0 : last - first + 1;
    }

    private int first(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        //left == mid;
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private int last(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right == 0) {
            return -1;
        }
        return nums[right - 1] == target ? right - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 4};
        System.out.println(new Solution().search(nums, 5));
    }
}