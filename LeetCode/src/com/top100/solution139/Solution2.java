package com.top100.solution139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/5 20:20
 * DFS——NOT AC
 */
class Solution2 {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, s.length() - 1, wordDict);
    }

    private boolean dfs(String s, int index, List<String> wordDict) {
        if (memo[index + 1] == 0) {
            return false;
        } else if (memo[index + 1] == 1) {
            return true;
        }
        if (index == -1) {
            return true;
        }
        String word = "";
        for (int i = index; i >= 0; i--) {
            word = s.charAt(i) + word;
            if (wordDict.contains(word)) {
                if (dfs(s, i - 1, wordDict)) {
                    return true;
                } else {
                    memo[index + 1] = 0;
                }
            }
        }
        memo[index + 1] = 0;
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String str = "catsandog";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
//        String str = "leetcode";
        System.out.println(new Solution2().wordBreak(str, wordDict));
    }
}