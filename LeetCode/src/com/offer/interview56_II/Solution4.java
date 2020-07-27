package com.offer.interview56_II;

/**
 * @author LiSheng
 * @date 2020/7/23 9:15
 */
public class Solution4 {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            String s = Integer.toBinaryString(num);
            int len = s.length();
            for (int i = 0; i < len; i++) {
                int tmp = s.charAt(len - i - 1) - '0';
                bit[i] += tmp;
            }
        }

        int res = 0;
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] % 3 == 1) {
                res += Math.pow(2, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,7,9,7,9,7};
        System.out.println(new Solution4().singleNumber(nums));
    }
}
