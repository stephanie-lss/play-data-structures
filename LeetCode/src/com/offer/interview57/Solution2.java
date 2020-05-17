package com.offer.interview57;

/**
 * @author LiSheng
 * @date 2020/5/13 21:34
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == tmp) {
                    return new int[]{nums[i], tmp};
                } else if (nums[mid] < tmp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        throw null;
    }
}
