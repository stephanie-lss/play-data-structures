package com.solution41;

/**
 * @author LiSheng
 * @date 2020/6/27 10:42
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            while (nums[i] - 1 != i && nums[i] >= 1 && nums[i] <= len) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}