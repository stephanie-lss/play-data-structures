package com.solution153;

/**
 * @author LiSheng
 * @date 2020/5/31 20:54
 */
class Solution2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && right >= 0) {
            return Math.min(nums[left], nums[right]);
        } else if (left < nums.length) {
            return nums[left];
        } else {
            return nums[right];
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3};
        System.out.println(new Solution2().findMin(nums));
    }
}
