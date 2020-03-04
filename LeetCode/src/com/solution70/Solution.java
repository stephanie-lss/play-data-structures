package com.solution70;

/**
 * @author LiSheng
 * @date 2020/2/23 13:52
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}