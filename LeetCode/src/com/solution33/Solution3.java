package com.solution33;

/**
 * @author LiSheng
 * @date 2020/5/31 16:52
 */
public class Solution3 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                //有两种情况
                if (nums[mid] > nums[right]) {
                    //mid在m1中
                    if (nums[left] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (nums[mid] > nums[right]) {
                    //mid在m1中
                    left = mid + 1;
                } else {
                    if (nums[right] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(new Solution3().search(nums, 8));
    }
}
