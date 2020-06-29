package com.interview.solution8_1;

/**
 * @author LiSheng
 * @date 2020/6/29 16:45
 */
class Solution {
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        long one = 1, two = 1, three = 2;
        for (int i = 3; i <= n; i++) {
            long tmp1 = three % 1000_000_007;
            long tmp2 = two % 1000_000_007;
            three = (tmp1 + (tmp2 + one) % 1000_000_007) % 1000_000_007;
            two = tmp1;
            one = tmp2;
        }
        return (int) three;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToStep(1000000));
    }
}