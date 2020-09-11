package com.array.easy.solution830;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/30 16:21
 */
public class Solution2 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();

        int[] freq = new int[26];

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (i != 0) {
                char preChar = S.charAt(i - 1);
                if (c != preChar) {
                    freq[preChar - 'a'] = 0;
                }
            }
            freq[c - 'a']++;
            if ((i == S.length() - 1 || S.charAt(i + 1) != S.charAt(i)) && freq[c - 'a'] >= 3) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i - freq[c - 'a'] + 1);
                tmp.add(i);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution2().largeGroupPositions("abbxxxxzzy");
    }
}
