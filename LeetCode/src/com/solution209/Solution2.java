package com.solution209;

/**
 * @author LiSheng
 * @date 2020/6/28 8:59
 */
public class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1, min = Integer.MAX_VALUE;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                min = Math.min(min, r - l + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        System.out.println(new Solution2().minSubArrayLen(4, nums));
    }
}
