package com.array.easy.solution1170;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/31 15:26
 */
public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //统计queries中每个字符串中的最小字母出现次数
        int[] q = getFreq(queries);

        int[] w = getFreq(words);

        Arrays.sort(w);
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (q[i] < w[j]) {
                    q[i] = w.length - j;
                    break;
                }
                if (j == w.length - 1) {
                    q[i] = 0;
                }
            }
        }
        return q;
    }

    private int[] getFreq(String[] queries) {
        int[] q = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] freq = new int[26];
            for (int j = 0; j < queries[i].length(); j++) {
                char c = queries[i].charAt(j);
                freq[c - 'a']++;
            }
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] != 0) {
                    q[i] = freq[j];
                    break;
                }
            }
        }
        return q;
    }

    public static void main(String[] args) {
        String[] q = {"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa", "babaa", "bbbbabaa"};
        String[] w = {"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab", "bbaaababba", "baaaaa"};
        new Solution().numSmallerByFrequency(q, w);
    }
}
