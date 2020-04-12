package com.math.easy.solution326;

/**
 * @author LiSheng
 * @date 2020/4/8 15:29
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        if (n == 0 || n == 2) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        } else {
            return false;
        }
    }
}
