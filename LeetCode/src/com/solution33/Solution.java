package com.solution33;

/**
 * @author LiSheng
 * @date 2020/4/29 12:58
 */
class Solution {
    public int search(int[] nums, int target) {
        //寻找旋转点
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >=nums[left]) {
                //mid左边有序
                if (target >= nums[left] && target < nums[mid]) {
                    return binarySearch(nums, left, mid, target);
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                //mid右边有序
                if (target > nums[mid] && target <= nums[right - 1]) {
                    return binarySearch(nums, mid + 1, right, target);
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, left, mid, target);
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 1;
        System.out.println(new Solution().search(nums, target));
    }
}
