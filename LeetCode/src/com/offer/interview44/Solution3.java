package com.offer.interview44;

/**
 * @author LiSheng
 * @date 2020/7/15 10:52
 */
public class Solution3 {
    public int findNthDigit(int n) {
        for (int i = 1; i < 1000; i++) {
            long count = (long) (9 * Math.pow(10, i - 1)) * i;
            if (count == n) {
                return ((int) (Math.pow(10, i + 1)) - 1) % 10;
            } else if (count > n) {
                return helper(n, (int) (Math.pow(10, i - 1)), i);
            } else {
                n -= count;
            }
        }
        return -1;
    }

    private int helper(long n, int start, int pow) {
        int m1 = (int) (n / pow);
        int m2 = (int) (n % pow);
        if (m2 == 0) {
            return (start + m1 - 1) % 10;
        } else {
            return (start + m1) / (int) (Math.pow(10, pow - m2)) % 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().findNthDigit(1000000000));
    }
}
