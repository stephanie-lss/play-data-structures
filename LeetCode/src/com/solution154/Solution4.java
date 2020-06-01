package com.solution154;

/**
 * @author LiSheng
 * @date 2020/5/31 21:34
 */
public class Solution4 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right--;
            }
        }
        return nums[left];
    }
}
