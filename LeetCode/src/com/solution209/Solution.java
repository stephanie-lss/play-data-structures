package com.solution209;

/**
 * @author LiSheng
 * @date 2020/2/18 10:38
 * 双索引技术，滑动窗口
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;   //nums[l,,,r]为滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
