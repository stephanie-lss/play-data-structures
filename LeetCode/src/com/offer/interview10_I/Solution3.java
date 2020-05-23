package com.offer.interview10_I;

/**
 * @author LiSheng
 * @date 2020/5/23 15:29
 */
public class Solution3 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int x = 0, y = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = (x + y) % 1000_000_007;
            x = y;
            y = tmp;
        }
        return x;
    }
}
