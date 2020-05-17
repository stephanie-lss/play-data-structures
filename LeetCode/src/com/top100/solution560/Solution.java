package com.top100.solution560;

/**
 * @author LiSheng
 * @date 2020/5/5 17:54
 * 暴力——NOT AC
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int len = 0; len < nums.length; len++) {
            for (int i = 0; i < nums.length - len; i++) {
                int sum = 0;
                for (int j = i; j <= i + len; j++) {
                    sum += nums[j];
                    if (sum > k) {
                        break;
                    }
                }
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}