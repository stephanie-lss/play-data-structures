package com.solution16;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/6/24 8:57
 */
class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int min = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}