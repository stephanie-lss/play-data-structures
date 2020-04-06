package com.array.easy.interview53_II;

/**
 * @author LiSheng
 * @date 2020/4/1 18:29
 */
public class Solution {
    public int missingNumber(int[] nums) {
        return findMissNumber(nums, 0);
    }

    private int findMissNumber(int[] nums, int start) {
        if (nums[start] != start) {
            return start;
        }
        if (start + 1 == nums.length) {
            return start + 1;
        }
        return findMissNumber(nums, start + 1);
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(new Solution().missingNumber(nums));
    }
}
