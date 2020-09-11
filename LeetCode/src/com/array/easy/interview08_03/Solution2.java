package com.array.easy.interview08_03;

/**
 * @author LiSheng
 * @date 2020/4/1 14:57
 */
public class Solution2 {
    public int findMagicIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return findMagicIndex(nums, left, right);
    }

    private int findMagicIndex(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = right - (right - left) / 2;
        if (mid == nums[mid]) {
            return mid;
        }

        if (findMagicIndex(nums, left, mid - 1) == -1) {
            return findMagicIndex(nums, mid + 1, right);
        }
        if (findMagicIndex(nums, mid + 1, right) == -1) {
            return findMagicIndex(nums, left, mid - 1);
        }
        return Math.min(findMagicIndex(nums, left, mid - 1), findMagicIndex(nums, mid + 1, right));
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 5};
        System.out.println(new Solution2().findMagicIndex(nums));
    }
}
