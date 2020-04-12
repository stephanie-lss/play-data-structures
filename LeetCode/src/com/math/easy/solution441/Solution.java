package com.math.easy.solution441;

/**
 * @author LiSheng
 * @date 2020/4/8 16:07
 */
public class Solution {
    public int arrangeCoins(int n) {
        int res = n;
        for (int i = 1; i <= n; i++) {
            res -= i;
            if (0 == res) {
                return i;
            } else if (0 > res) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(10));
    }
}
