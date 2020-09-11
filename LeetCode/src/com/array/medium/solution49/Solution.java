package com.array.medium.solution49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 12:39
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            List<String> tmp = new ArrayList<>(Arrays.asList(strs[i]));
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && check(strs[i], strs[j])) {
                    visited[j] = true;
                    tmp.add(strs[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}
