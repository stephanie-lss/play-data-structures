package com.solution139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/25 12:02
 */
class Solution {

    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")) {
            return true;
        }
        memo = new int[s.length()];
        return dfs(s, 0, wordDict);
    }

    private boolean dfs(String s, int index, List<String> wordDict) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] == 1) {
            return true;
        } else if (memo[index] == -1) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                if (dfs(s, i + 1, wordDict)) {
                    memo[index] = 1;
                    return true;
                }
                memo[index] = -1;
            }
        }
        memo[index] = -1;
        return false;
    }

    public static void main(String[] args) {
        String str = "aaaaaaa";
        List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
        System.out.println(new Solution().wordBreak(str, wordDict));
    }
}