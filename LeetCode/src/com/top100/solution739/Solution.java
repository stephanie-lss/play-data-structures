package com.top100.solution739;

/**
 * @author LiSheng
 * @date 2020/4/30 16:18
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            //隔天就升温了
            if (T[i] < T[i + 1]) {
                dp[i] = 1;
            } else {
                //当天温度大于等于后一天的温度，去找后一天升温的那一天（即为nextUp，当天温度记为nextUpT）
                int idx = i + 1 + dp[i + 1];
                while (idx < n) {
                    //如果当天温度比nextUpT低，可以得出结论
                    if (T[i] < T[idx]) {
                        dp[i] = idx - i;
                        break;
                    }
                    //如果当天温度比nextUpT高或者相等，并且nextUp往后不再升温了
                    if (dp[idx] == 0) {
                        dp[i] = 0;
                        break;
                    }
                    //否则，继续去寻找nextUp升温的那一天
                    idx += dp[idx];
                }
            }
        }
        return dp;
    }
}
