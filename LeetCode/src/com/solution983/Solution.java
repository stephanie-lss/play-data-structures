package com.solution983;

/**
 * @author LiSheng
 * @date 2020/5/6 21:33
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length, maxDay = days[n - 1], minDay = days[0];
        // dp[i] 来表示从第 i 天开始到一年的结束时我们需要花的钱
        int[] dp = new int[maxDay + 31];
        for (int i = maxDay, j = n - 1; i >= minDay; i--) {
            if (i == days[j]) {
                dp[i] = Math.min(Math.min(costs[0] + dp[i + 1], costs[1] + dp[i + 7]), costs[2] + dp[i + 30]);
                j--;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[minDay];
    }
}
