package com.dp.linear.solution53;

/**
 * @author LiSheng
 * @date 2020/5/3 10:01
 */
class Solution5 {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid + 1, right);
        int leftTmp = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftTmp) {
                leftTmp = sum;
            }
        }
        int rightTmp = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightTmp) {
                rightTmp = sum;
            }
        }
        return Math.max(leftSum, Math.max(rightSum, leftTmp + rightTmp));
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution5().maxSubArray(nums));
    }
}