package com.solution704;

/**
 * @author LiSheng
 * @date 2020/4/29 20:00
 */
class Solution2 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
