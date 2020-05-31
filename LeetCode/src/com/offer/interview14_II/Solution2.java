package com.offer.interview14_II;

/**
 * @author LiSheng
 * @date 2020/5/24 16:13
 */
public class Solution2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static void main(String[] args) {
        int n = 23;
        System.out.println(new Solution2().cuttingRope(n));
    }
}
