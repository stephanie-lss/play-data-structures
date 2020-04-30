package com.solution154;

/**
 * @author LiSheng
 * @date 2020/4/29 15:49
 */
class Solution2 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right - 1]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right - 1]) {
                right = mid + 1;
            } else if (nums[mid] == nums[right - 1]) {
                if (mid == right - 1) {
                    return Math.min(nums[mid], nums[left]);
                } else {
                    right--;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 1};
        int[] nums2 = {9, 1, 9, 9};
        int[] nums3 = {3, 3, 3, 1, 3};
        System.out.println(new Solution2().findMin(nums));
        System.out.println(new Solution2().findMin(nums2));
        System.out.println(new Solution2().findMin(nums3));
    }
}
