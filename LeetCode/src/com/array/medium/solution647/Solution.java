package com.array.medium.solution647;

/**
 * @author LiSheng
 * @date 2020/4/14 10:54
 */
public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaasdsafwesfdfqrferfwadesda"));
    }
}
