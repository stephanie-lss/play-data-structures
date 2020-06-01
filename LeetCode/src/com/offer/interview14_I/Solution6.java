package com.offer.interview14_I;

/**
 * @author LiSheng
 * @date 2020/6/1 11:18
 */
public class Solution6 {
    public int cuttingRope(int n) {
        int pow = n / 3;
        int remain = n % 3;
        if (remain != 0) {
            pow -= 1;
            remain += 3;
        }
        return quickPow(3, pow) * remain;
    }

    private int quickPow(int num, int pow) {
        int res = 1;
        while (pow != 0) {
            if (num % 2 != 0) {
                res = quickPow(num, pow / 2) * quickPow(num, pow / 2) * num;
            } else {
                res = quickPow(num, pow / 2) * quickPow(num, pow / 2);
            }
            pow /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().cuttingRope(10));
    }
}
