package com.math.easy.solution7;

/**
 * @author LiSheng
 * @date 2020/2/22 16:09
 */
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) ? 0 : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
    }
}
