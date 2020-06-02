package com.offer.interview15;

/**
 * @author LiSheng
 * @date 2020/6/2 8:51
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while ((n != 0)) {
            sum += (n & 1) != 0 ? 1 : 0;
            n = n >> 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}