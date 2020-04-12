package com.math.easy.solution1025;

/**
 * @author LiSheng
 * @date 2020/4/9 21:13
 */
public class Solution2 {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().divisorGame(4));
    }
}
