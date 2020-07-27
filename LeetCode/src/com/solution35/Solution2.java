package com.solution35;

/**
 * @author LiSheng
 * @date 2020/7/20 9:09
 */
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (mid - 1 >= 0 && nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else if (nums[mid] < target) {
                if (mid + 1 < len && nums[mid + 1] >= target) {
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        if (right == -1) {
            return 0;
        } else {
            return len;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Solution2().searchInsert(nums, 0));
    }
}
