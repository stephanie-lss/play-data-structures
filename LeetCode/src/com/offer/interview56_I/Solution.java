package com.offer.interview56_I;

/**
 * @author LiSheng
 * @date 2020/5/12 18:58
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int firstOne = x ^ -x;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & firstOne) == 0) {
                res[0] ^= num;
            }
        }
        res[1] = x ^ res[0];
        return res;
    }
}