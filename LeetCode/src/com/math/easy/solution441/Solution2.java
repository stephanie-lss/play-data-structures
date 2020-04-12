package com.math.easy.solution441;

/**
 * @author LiSheng
 * @date 2020/4/8 16:07
 */
public class Solution2 {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 1 / 8) - 1 / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().arrangeCoins(10));
    }
}
