package com.top100.solution139;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/5 21:27
 */
class Solution5 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dicts = new HashSet<>(wordDict);
        if (s.length() == 1 && wordDict.contains(s)) {
            return true;
        }
        int n = s.length();
        //dp[i]表示前i-1个字符组成的单词是否存在于字典中
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dicts.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> word = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String str = "catsandog";
        System.out.println(new Solution5().wordBreak(str, word));
    }
}