package com.solution136;

/**
 * @author LiSheng
 * @date 2020/5/14 21:57
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}