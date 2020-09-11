package com.top100.solution139;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/5 20:20
 * DFS——NOT AC
 */
class Solution {
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, 0, wordDict);
    }

    private boolean dfs(String s, int index, List<String> wordDict) {
        if (memo[index] == 0) {
            return false;
        } else if (memo[index] == 1) {
            return true;
        }
        if (index == s.length()) {
            return true;
        }
        String word = "";
        for (int i = index; i < s.length(); i++) {
            word += s.charAt(i);
            if (wordDict.contains(word)) {
                System.out.println(word);
                if (dfs(s, i + 1, wordDict)) {
                    memo[index] = 1;
                    return true;
                } else {
                    memo[index] = 0;
                }
            }
        }
        memo[index] = 0;
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "og", "sand", "and", "cat"));
        String str = "catsandog";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
//        String str = "leetcode";
        System.out.println(new Solution().wordBreak(str, wordDict));
    }
}