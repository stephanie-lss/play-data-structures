package com.interview.solution5_1;

/**
 * @author LiSheng
 * @date 2020/6/28 9:18
 */
class Solution {
    public int insertBits(int N, int M, int i, int j) {
        return (((N >>> i >>> (j - i + 1) << (j - i + 1)) ^ M) << i) ^ (N & (int) (Math.pow(2, i) - 1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().insertBits(1024, 19, 2, 6));
        System.out.println(new Solution().insertBits(0, 31, 0, 4));
    }
}