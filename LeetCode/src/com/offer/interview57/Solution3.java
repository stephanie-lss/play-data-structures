package com.offer.interview57;

/**
 * @author LiSheng
 * @date 2020/5/13 21:48
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        throw null;
    }
}
