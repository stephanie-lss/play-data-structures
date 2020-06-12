package com.solution739;

/**
 * @author LiSheng
 * @date 2020/6/11 8:45
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dp = new int[n];
        if (n == 0) {
            return dp;
        }
        //dp[i]表示第i天在多少天的时候会升高温度
        //base case-最后一天肯定是0
        for (int i = n - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                dp[i] = 1;
            } else {
                //找下一个该天气升高温度的日子
                int next = dp[i + 1] + i + 1;
                while (next < n) {
                    if (T[i] < T[next]) {
                        dp[i] = next - i;
                        break;
                    } else {
                        if (dp[next] == 0) {
                            break;
                        }
                        next += dp[next];
                    }
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new Solution().dailyTemperatures(T);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}