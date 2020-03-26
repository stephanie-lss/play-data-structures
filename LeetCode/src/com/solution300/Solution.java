package com.solution300;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/8 10:43
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i],1+res[j]);
                }
            }
        }
        Arrays.sort(res);
        return res[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
