package com.array.easy.interview53_II;

/**
 * @author LiSheng
 * @date 2020/4/1 18:29
 */
public class Solution2 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int r = nums[i] ^ i;
            if (r != 0) {
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution2().missingNumber(nums));
    }
}
