package com.array.medium.solution81;

/**
 * @author LiSheng
 * @date 2020/4/27 11:42
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                //mid前部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                //mid后部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 1};
        System.out.println(new Solution().search(nums, 3));
    }
}
