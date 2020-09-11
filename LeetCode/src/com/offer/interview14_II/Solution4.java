package com.offer.interview14_II;

/**
 * @author LiSheng
 * @date 2020/6/1 14:29
 */
public class Solution4 {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int pow = n / 3;
        int remain = n % 3;
        if (remain == 2) {
            return (int) (quickPow(3, pow) * remain % 1000_000_007);
        } else {
            return (int) (quickPow(3, pow - 1) * (remain + 3) % 1000_000_007);
        }
    }

    private long quickPow(int num, int pow) {
        long tmp = num, res = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                tmp %= 1000_000_007;
                res = res * tmp % 1000_000_007;
            }
            tmp = tmp * tmp % 1000_000_007;
            pow /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().cuttingRope(1000));
    }
}
