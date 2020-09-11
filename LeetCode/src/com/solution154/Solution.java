package com.solution154;

/**
 * @author LiSheng
 * @date 2020/4/29 15:49
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                //有两种情况
                if (nums[mid] < nums[right - 1]) {
                    return nums[left];
                } else if (nums[mid] > nums[right - 1]) {
                    left = mid + 1;
                } else if (nums[mid] == nums[right - 1]) {
                    return nums[left];
                }
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                } else {
                    right = mid;
                }
            } else {
                //也存在两种情况
                if (nums[mid] > nums[right - 1]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right - 1]) {
                    return nums[mid];
                } else if (nums[mid] == nums[right - 1]) {
                    left++;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        int[] nums2 = {2,2,2,0,1};
        System.out.println(new Solution().findMin(nums));
        System.out.println(new Solution().findMin(nums2));
    }
}
