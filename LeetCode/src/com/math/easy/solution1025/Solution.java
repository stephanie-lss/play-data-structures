package com.math.easy.solution1025;

/**
 * @author LiSheng
 * @date 2020/4/9 21:13
 */
public class Solution {
    public boolean divisorGame(int N) {
        boolean flag = false;
        return helper(N, flag);
    }

    private boolean helper(int N, boolean flag) {
        for (int x = 1; x < N; x++) {
            if (N % x == 0) {
                return helper(N - x, !flag);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divisorGame(4));
    }
}
