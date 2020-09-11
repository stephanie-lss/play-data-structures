package com.interview.solution56_1;

/**
 * @author LiSheng
 * @date 2020/4/28 9:42
 */
public class Solution2 {
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int firstOne = x & -x;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & firstOne) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
