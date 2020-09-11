package com.array.easy.solution1170;

/**
 * @author LiSheng
 * @date 2020/3/31 16:09
 */
public class Solution2 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        // 统计
        int [] counter = new int[12];
        for (int i = 0; i < words.length; i++)
            counter[fs(words[i])]++;

        // 累和
        for (int i = 9; i >= 0; i--)
            counter[i] += counter[i + 1];

        // 拿值
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ret[i] = counter[fs(queries[i]) + 1];

        return ret;
    }

    public int fs(String str) {

        if (str.length() < 2)
            return str.length();

        char temp = str.charAt(0);
        int max = 1;
        for (int i = 1; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == temp)
                max += 1;
            else if (ch < temp) {
                max = 1;
                temp = ch;
            } else
                continue;
        }
        return max;
    }

    public static void main(String[] args) {
        String[] q = {"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa", "babaa", "bbbbabaa"};
        String[] w = {"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab", "bbaaababba", "baaaaa"};
        new Solution2().numSmallerByFrequency(q, w);
    }
}
