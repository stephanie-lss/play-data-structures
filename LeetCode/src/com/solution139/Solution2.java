package com.solution139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/25 12:28
 */
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示s中的前i个字符组成的一个或多个串均存在于wordDict中
        boolean[] dp = new boolean[s.length() + 1];
        //base case
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    if (wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String str = "aaaaaaa";
        List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
        System.out.println(new Solution2().wordBreak(str, wordDict));
    }
}
