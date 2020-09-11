package com.offer.interview56_II;

/**
 * @author LiSheng
 * @date 2020/5/12 16:19
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= count[i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 4};
        System.out.println(new Solution2().singleNumber(nums));
    }
}
