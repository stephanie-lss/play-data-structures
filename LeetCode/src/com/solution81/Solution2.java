package com.solution81;

/**
 * @author LiSheng
 * @date 2020/5/31 20:20
 */
class Solution2 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                if (nums[mid] > nums[right]) {
                    //mid在左边升序数组
                    if (nums[left] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] < nums[right]) {
                    //mid在右边升序数组
                    right = mid - 1;
                } else if (nums[mid] == nums[right]) {
                    right--;
                }
            } else if (nums[mid] < target) {
                if (nums[mid] > nums[right]) {
                    //mid在左边升序数组
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    //mid在右边升序数组
                    if (nums[right] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] == nums[right]) {
                    right--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3,1};
        System.out.println(new Solution2().search(nums, 3));
    }
}