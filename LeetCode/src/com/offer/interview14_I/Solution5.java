package com.offer.interview14_I;

/**
 * @author LiSheng
 * @date 2020/6/1 11:13
 */
public class Solution5 {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 4) {
            return n;
        }
        return 3 * dfs(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().cuttingRope(10));
    }
}

