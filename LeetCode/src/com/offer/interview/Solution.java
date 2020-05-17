package com.offer.interview;

/**
 * @author LiSheng
 * @date 2020/5/12 18:33
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(new Solution().hammingWeight(n));
    }
}