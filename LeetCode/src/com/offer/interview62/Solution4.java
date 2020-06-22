package com.offer.interview62;

/**
 * @author LiSheng
 * @date 2020/6/19 9:41
 */
public class Solution4 {
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
