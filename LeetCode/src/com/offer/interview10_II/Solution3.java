package com.offer.interview10_II;

/**
 * @author LiSheng
 * @date 2020/5/22 15:06
 */
public class Solution3 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (pre + cur) % 1000_000_007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution3().numWays(n));
    }
}
