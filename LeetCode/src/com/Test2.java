package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test2 {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            //A操作
            dp[i] = dp[i - 1] + 1;
            //C-A->C-C->C-V
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(new Test2().maxA(N));
    }
}