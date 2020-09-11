package com.math.easy.solution231;

/**
 * @author LiSheng
 * @date 2020/4/8 14:29
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (true) {
            int i = n % 2;
            n /= 2;
            if (i != 0) {
                return false;
            }
            if (n == 1) {
                break;
            }
        }
        return true;
    }
}