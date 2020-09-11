package com.array.easy.solution674;

/**
 * @author LiSheng
 * @date 2020/3/30 13:34
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                res = Math.max(res, count + 1);
                count = 0;
            }
        }
        res = Math.max(res, count + 1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Solution().findLengthOfLCIS(nums));
    }
}
