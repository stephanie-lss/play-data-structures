package com.offer.interview14_II;

/**
 * @author LiSheng
 * @date 2020/5/24 15:38
 */
class Solution {

    public int cuttingRope(int n) {
        return n <= 3 ? n - 1 : (int) cutHelper(n) % 100_000_0007;
    }

    private long cutHelper(int n) {
        if (n < 5) {
            return n;
        }
        return 3 * cutHelper(n - 3);
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(new Solution().cuttingRope(n));
    }
}