package com.top100.solution31;

/**
 * @author LiSheng
 * @date 2020/5/8 17:11
 */
class Solution {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int index = i + 1;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        index = j;
                    } else {
                        break;
                    }
                }
                swap(nums, i, index);
                //排翻转后面的数组
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        new Solution().nextPermutation(nums);
    }
}