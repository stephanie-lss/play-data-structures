package com.interview.solution8_5;

/**
 * @author LiSheng
 * @date 2020/6/30 19:05
 */
class Solution {
    public int multiply(int A, int B) {
        if (A > B) {
            A = A ^ B;
            B = A ^ B;
            A = A ^ B;
        }
        return helper(A, B);
    }

    private int helper(int a, int b) {
        if (a == 0) {
            return 0;
        }
        return b + helper(a - 1, b);
    }
}