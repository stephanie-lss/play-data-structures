package com.offer.interview10_I;

/**
 * @author LiSheng
 * @date 2020/5/31 13:42
 */
public class Solution4 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int first = 0, second = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = second;
            second = (first + second) % 1000_000_007;
            first = tmp;
        }
        return second;
    }
}
