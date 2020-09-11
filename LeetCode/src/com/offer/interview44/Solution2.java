package com.offer.interview44;

/**
 * @author LiSheng
 * @date 2020/6/10 14:37
 */
public class Solution2 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        int m = 0;
        int tmp = 0;
        while (true) {
            long count = (long) (9 * Math.pow(10, m) * (m + 1));
            if (tmp + count > n) {
                return helper((int) Math.pow(10, m) - 1, tmp, m + 1, n);
            }else {
                tmp += count;
                m++;
            }
        }
    }

    private int helper(int start, int tmp, int m, int n) {
        int p = (n - tmp) / m;
        int q = (n - tmp) % m;
        start += p;
        if (q == 0) {
            return start % 10;
        } else {
            return String.valueOf(start + 1).charAt(q - 1) - '0';
        }
    }
}
