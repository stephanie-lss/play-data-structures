package com.offer.interview46;

/**
 * @author LiSheng
 * @date 2020/5/19 15:20
 */
public class Solution3 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        //dp[i]表示str的前i个数字能翻译成字符串的数量
        int[] dp = new int[n + 1];
        //base case——比如22->dp[2] = 2;,dp[1] = 1;所以dp[0] = 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String tmp = str.substring(i - 2, i);
            if (tmp.compareTo("25") <= 0 && tmp.compareTo("10") >= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().translateNum(1225));
//        System.out.println("12".compareTo("26"));
//        System.out.println("12".compareTo("9"));
    }
}
