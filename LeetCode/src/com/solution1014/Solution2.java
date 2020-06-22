package com.solution1014;

/**
 * @author LiSheng
 * @date 2020/6/17 8:41
 */
public class Solution2 {
    public int maxScoreSightseeingPair(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + A[i] - A[i - 1] - 1, A[i] + A[i - 1] - 1);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};
        System.out.println(new Solution2().maxScoreSightseeingPair(A));
    }
}
