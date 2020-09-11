package com.math.easy.solution172;

/**
 * @author LiSheng
 * @date 2020/4/8 12:14
 */
public class Solution2 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().trailingZeroes(50));
    }
}
